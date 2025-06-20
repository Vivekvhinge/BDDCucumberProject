package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.Readconfig;

//Session 4
//Parent class
public class BaseClass {
	
	/*
	Base class: is created in step defn file to maintain the common methods & variable .
	& extend the step den file means base class will be parent class and step defn file will be child class  
	*/
	
	public  static WebDriver driver; //created webdriver object
	public LoginPage loginpg; //created login page object 
	public AddNewCustomerPage AddNewCustPg;  //created AddNewCustomerPage object 
	public SearchCustomerPage SearchCustomerPg; //created SearchCustomerPage object 
	public static Logger log; //created logger class refer session 6
	//public Properties readconfig;//create properties class refer session 7 
	public Readconfig readconfig; //object of readconfig.java file 

	//create a class for emailid so  it will create unique email id so every time we don't have to hardcoded for new mail 
	public String generatemailid()
	{
		return (RandomStringUtils.randomAlphabetic(5)); //RandomStringUtils to generate random strings &randomAlphabetic for alphabet length
	}

}
