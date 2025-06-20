package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Readconfig {

	//properties class obj
	Properties Properties;
	//string path for config.properties file
	String path="config.properties";



	//constructor
	public Readconfig() {

		//now initialize the properties
		Properties=new Properties();

		try {
			//to open config.properties file in input mode  and load the file
			//now create obj of fileinputstream for readonly mode to open properties file refer session 7
			FileInputStream fis1=new FileInputStream(path);  
			Properties.load(fis1); //to load the fis1[which stores the path of config.properties] object refer session 7
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	//method added for the keyvariable 
	public String getbrowser() {
	    String value = Properties.getProperty("browser"); // Assuming 'Properties' is properly initialized (e.g., from a config file)
	    if (value != null) {
	        return value;
	    } 
	    else { 
	        throw new RuntimeException("Browser not specified in properties file"); // Changed to RuntimeException
	    }
	}





}
