
package org.example.customer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.customer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LookupCustomerRequest_QNAME = new QName("http://www.example.org/customer/", "lookupCustomerRequest");
    private final static QName _LookupCustomerResponse_QNAME = new QName("http://www.example.org/customer/", "lookupCustomerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.customer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LookupCustomerRequestType }
     * 
     */
    public LookupCustomerRequestType createLookupCustomerRequestType() {
        return new LookupCustomerRequestType();
    }

    /**
     * Create an instance of {@link LookupCustomerResponseType }
     * 
     */
    public LookupCustomerResponseType createLookupCustomerResponseType() {
        return new LookupCustomerResponseType();
    }

    /**
     * Create an instance of {@link CustomerType }
     * 
     */
    public CustomerType createCustomerType() {
        return new CustomerType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupCustomerRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/customer/", name = "lookupCustomerRequest")
    public JAXBElement<LookupCustomerRequestType> createLookupCustomerRequest(LookupCustomerRequestType value) {
        return new JAXBElement<LookupCustomerRequestType>(_LookupCustomerRequest_QNAME, LookupCustomerRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LookupCustomerResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/customer/", name = "lookupCustomerResponse")
    public JAXBElement<LookupCustomerResponseType> createLookupCustomerResponse(LookupCustomerResponseType value) {
        return new JAXBElement<LookupCustomerResponseType>(_LookupCustomerResponse_QNAME, LookupCustomerResponseType.class, null, value);
    }

}
