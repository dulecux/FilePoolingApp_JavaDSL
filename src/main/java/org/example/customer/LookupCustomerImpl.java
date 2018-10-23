package org.example.customer;

import javax.jws.WebService;

@WebService(
			serviceName="CustomerService",
			portName="CustomerPort",
			targetNamespace="http://www.example.org/customer/",
            wsdlLocation = "file:\\C:\\Users\\dule\\redHatWorkspace\\zadatak3JavaDsl\\src\\main\\resources\\wsdl\\CustomerService.wsdl",
            endpointInterface="org.example.customer.CustomerPortType")
public class LookupCustomerImpl implements CustomerPortType {

	@Override
	public LookupCustomerResponseType lookupCustomer(LookupCustomerRequestType in) {
		
		return null;
	}
   
	
	public String getRequest(LookupCustomerRequestType in) {
		
		int id = in.getCustomerId();
		
		return "select * from dbo.Customer where customerId = " + id;
		
	}
	
	public String getResponse(LookupCustomerResponseType out) {
		
		String fn = out.getCustomer().getFirstname();
		String ln = out.getCustomer().getLastname();
		String address = out.getCustomer().getAddress();
		String city = out.getCustomer().getCity();
		String state = out.getCustomer().getState();
		String telephone = out.getCustomer().getTelephone();
		String email = out.getCustomer().getEmail();
		
		
	   return "Customer: "+ fn+", "+ln+", "+address+", "+city+", "+state+", "+telephone+", "+email+".";
	}
	
	public String getRequestId(LookupCustomerRequestType in) {
		return "LookupCustomerRequestType [customerId=" + in.getCustomerId() + "]";
	}
	
	
}
