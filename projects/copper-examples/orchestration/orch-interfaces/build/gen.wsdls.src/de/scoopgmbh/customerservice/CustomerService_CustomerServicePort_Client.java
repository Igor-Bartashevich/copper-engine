
package de.scoopgmbh.customerservice;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2013-04-08T12:41:16.244+02:00
 * Generated source version: 2.6.0
 * 
 */
public final class CustomerService_CustomerServicePort_Client {

    private static final QName SERVICE_NAME = new QName("http://customerservice.scoopgmbh.de/", "CustomerServiceService");

    private CustomerService_CustomerServicePort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = CustomerServiceService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        CustomerServiceService ss = new CustomerServiceService(wsdlURL, SERVICE_NAME);
        CustomerService port = ss.getCustomerServicePort();  
        
        {
        System.out.println("Invoking getCustomersByMsisdn...");
        de.scoopgmbh.customerservice.GetCustomersByMsisdnRequest _getCustomersByMsisdn_parameters = null;
        de.scoopgmbh.customerservice.GetCustomersByMsisdnResponse _getCustomersByMsisdn__return = port.getCustomersByMsisdn(_getCustomersByMsisdn_parameters);
        System.out.println("getCustomersByMsisdn.result=" + _getCustomersByMsisdn__return);


        }

        System.exit(0);
    }

}