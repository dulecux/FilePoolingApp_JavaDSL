package com.mycompany;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;


public class Launcher {
   
    public static void main(String[] args) throws Exception {
      
    	
    			SimpleRegistry reg = new SimpleRegistry();
    			
    			CustomerBuilder cb = new CustomerBuilder();
    	
    			reg.put("cusBuilder", cb);
    		
    			
    			CamelContext ctx = new DefaultCamelContext(reg);
    			
    			try {
    				ctx.addRoutes(new CamelRoute());
    				ctx.start();
    				Thread.sleep(5 * 60 * 1000);
    				ctx.stop();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
    	
    }
}
