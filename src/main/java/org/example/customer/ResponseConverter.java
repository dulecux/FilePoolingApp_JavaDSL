package org.example.customer;

import java.util.ArrayList;

import java.util.LinkedHashMap;

//import javax.xml.soap.SOAPException;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
//import org.apache.cxf.binding.soap.SoapFault;

public class ResponseConverter implements Processor {

	@Override
	public void process(Exchange ex) throws Exception {
		
		ArrayList<LinkedHashMap> list =  (ArrayList<LinkedHashMap>) ex.getIn().getBody();
		
		
		LinkedHashMap<String,String> hm = list.get(0);
		
	 
		
		CustomerType ct = new CustomerType();
		
		ct.setFirstname(hm.get("firstName"));
		ct.setLastname(hm.get("lastName"));
		ct.setAddress(hm.get("address"));
		ct.setCity(hm.get("city"));
		ct.setState(hm.get("state"));
		ct.setTelephone(hm.get("telephone"));
		ct.setEmail(hm.get("email"));
		
		
		
		LookupCustomerResponseType rt = new LookupCustomerResponseType();
		rt.setCustomer(ct);
		ex.getIn().setBody(rt);
	
	    
	}

}
