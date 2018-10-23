package com.mycompany;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.example.customer.LookupCustomerRequestType;


public class CamelRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		    
		   onException(java.lang.Exception.class).onWhen(exceptionMessage().contains("Customer already exists"))
		   .useOriginalMessage().handled(true).to("direct:sendError");
		   
		   onException(java.lang.Exception.class).onWhen(exceptionMessage().contains("Customer not found"))
		   .continued(true);
		
		    //cxfEndpoint
		    
		   final CxfEndpoint cxfEndpoint = new CxfEndpoint();
		   cxfEndpoint.setBeanId("customerPortType");
		   cxfEndpoint.setAddress("http://localhost:9000/customer/");
		   cxfEndpoint.setServiceClass("org.example.customer.CustomerPortType");
		   cxfEndpoint.setCamelContext(getContext());
		
		   
		    //route
		
		    from("file://src/main/resources/customer?noop=true").streamCaching().process(new Processor() {
			
			@Override
			public void process(Exchange ex) throws Exception {
				
				String[] parts = ex.getIn().getBody(String.class).split("_");
				
				ex.setProperty("firstName", parts[0]);
				ex.setProperty("lastName", parts[1]);
				ex.setProperty("address", parts[2]);
				ex.setProperty("city", parts[3]);
				ex.setProperty("state", parts[4]);
				ex.setProperty("telephone", parts[5]);
				ex.setProperty("email", parts[6]);
				int id = Integer.parseInt(parts[7]);
				ex.setProperty("customerId", id);
				
				LookupCustomerRequestType lcrt = new LookupCustomerRequestType();
				lcrt.setCustomerId(id);
				
				ex.getIn().setBody(lcrt);
				
			}
		}).to(ExchangePattern.InOut, cxfEndpoint).choice().when(body().isNotNull())
		    .throwException(new java.lang.Exception("Customer already exists"))
		    .otherwise()
		    .process(new Processor() {
				
				@Override
				public void process(Exchange ex) throws Exception {
					
					Customer cus = new Customer((String) ex.getProperty("firstName"),
							                   (String) ex.getProperty("lastName"),
							                   (String) ex.getProperty("address"),
							                   (String) ex.getProperty("city"),
							                   (String) ex.getProperty("state"),
							                   (String) ex.getProperty("telephone"),
							                   (String) ex.getProperty("email"),
							                   (Integer) ex.getProperty("customerId"));
					
					
					    ex.getIn().setBody(cus);
							                   
					
					
				}
			}).marshal().json(JsonLibrary.Jackson).setHeader(Exchange.HTTP_METHOD,constant("POST"))
		    .to(ExchangePattern.InOut,"http://localhost:9002/customers/create").log("${body}").to("direct:toCsv");
		    
		    from("direct:sendError").to("file://target/error/");
		    
		    from("direct:toCsv").bean("cusBuilder").marshal().bindy(BindyType.Csv, Customer.class).split(body()).to("file://target/success/?fileName=${property.firstName}_${property.lastName}.csv");
		
	}
}
