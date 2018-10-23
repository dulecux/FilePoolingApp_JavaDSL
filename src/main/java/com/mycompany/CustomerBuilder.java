package com.mycompany;

import java.util.Map;

import org.apache.camel.Properties;



@SuppressWarnings("deprecation")
public class CustomerBuilder {
	
	public Customer makeCustomer(@Properties Map<String, Object> prop) {
		
		Customer customer = new Customer();
		
		customer.setFirstName((String) prop.get("firstName"));
		customer.setLastName((String)prop.get("lastName"));
		customer.setAddress((String) prop.get("address"));
		customer.setCity((String)prop.get("city"));
		customer.setState((String)prop.get("state"));
		customer.setTelephone((String)prop.get("telephone"));
		customer.setEmail((String)prop.get("email"));
		customer.setCustomerId((int)prop.get("customerId"));
		
		return customer;
	}

}
