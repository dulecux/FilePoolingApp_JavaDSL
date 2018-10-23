package com.mycompany;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;


@XmlRootElement(name= "customer")
@XmlAccessorType(XmlAccessType.FIELD)
@CsvRecord(separator = ",")


public class Customer {
	
	@XmlAttribute
	@DataField(pos = 1,required = true)
	protected String firstName;
	@XmlAttribute
	@DataField(pos = 2,required = true)
	protected String lastName;
	@XmlAttribute
	@DataField(pos = 3,required = true)
	protected String address;
	@XmlAttribute
	@DataField(pos = 4,required = true)
	protected String city;
	@XmlAttribute
	@DataField(pos = 5,required = true)
	protected String state;
	@XmlAttribute
	@DataField(pos = 6,required = true)
	protected String telephone;
	@XmlAttribute
	@DataField(pos = 7,required = true)
	protected String email;
	@XmlAttribute
	@DataField(pos = 8,required = true)
	protected int customerId;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Customer(String firstName, String lastName, String address, String city, String state, String telephone,
			String email, int customerId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.telephone = telephone;
		this.email = email;
		this.customerId = customerId;
	}
	
	public Customer() {
		
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", telephone=" + telephone + ", email=" + email + ", customerId=" + customerId
				+ "]";
	}

	
	
	
	
	
}
