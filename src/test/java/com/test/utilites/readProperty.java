package com.test.utilites;


import java.io.FileReader;
import java.util.Properties;
import java.util.ResourceBundle;

public class readProperty {
	
	
	
	
	public Properties readPropertyFile(String file) {
		Properties prop =  new Properties();;
		try {
			
			FileReader fr= new FileReader(file);
		   
			prop.load(fr);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return prop;
		
		
	}
	
	
	public ResourceBundle readResources(String file) {
		
		
		ResourceBundle resource=ResourceBundle.getBundle(file);
		return resource;
	}

}
