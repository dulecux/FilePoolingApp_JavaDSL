package org.example.customer;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CustomException implements Processor {

	@Override
	public void process(Exchange ex ) throws Exception {
		// TODO Auto-generated method stub
		 String faultMessage = "Customer not found!";
		
		 ex.getOut().setBody(new Exception(faultMessage));
		 ex.getOut().setFault(true);
		 
		 
		
		
	}

}
