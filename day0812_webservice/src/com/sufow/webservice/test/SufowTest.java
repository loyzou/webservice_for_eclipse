package com.sufow.webservice.test;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.sufow.webservice.SufowWebService;

public class SufowTest {

	  /** 
     *  第二种 
     *  使用axis2 RPC调用webservice 需要导入相应的jar包 
     */  
    public void testRPC(){  
        try{  
            RPCServiceClient client = new RPCServiceClient();  
            Options options = client.getOptions();  
            String url = "http://localhost:8080/day0812_webservice/services/SufowWebService?wsdl";  
            EndpointReference end = new EndpointReference(url);  
            options.setTo(end);  
              
            Object[] obj = new Object[]{"tom"};  
             Class<?>[] classes = new Class[] { String.class };    
              
            QName qname = new QName("http://webservice.sufow.com", "showSufow");    
            String result = (String) client.invokeBlocking(qname, obj,classes)[0];  
            System.out.println(result);  
        }catch(AxisFault e){  
            e.printStackTrace();  
        }  
    }  
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SufowTest sufow = new SufowTest();
		sufow.testRPC();
	}

}
