package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {

	//dont add public class void main 

	WebDriver ldriver; //cretaed webdriver with obj "ldriver" for local driver

	//now create constructor
	public LoginPage(WebDriver rdriver)  //classname & methodname should be same,& "rdriver"=remotedriver,& only one parameter is accepted cz of parameterize constructor
	{
		//assign local driver to remote driver
		ldriver=rdriver;

		//
		PageFactory.initElements(rdriver,this );

	}

	//now use @Findby method  by id to locate the WebElement of email id
	@FindBy(id="Email")
	WebElement email;

	//now use @Findby method by id to locate the WebElement of password
	@FindBy(id="Password")
	WebElement password;


	//now use @Findby method by xpath to locate the WebElement of button
	@FindBy(xpath ="//button[@class='button-1 login-button']")
	WebElement loginbtn;
	
	
	//now use @Findby method by lintext to locate the WebElement of logoutbutton
	@FindBy (linkText = "Logout")
	WebElement Logout;


	////now we will do actions by methods on the above code [webelement]

	//create action method for email
	public void enteremail(String emailadd) //in method added para as string to store the email id 
	{
		email.clear();
		email.sendKeys(emailadd); //taken weblemt to send with string emailadd

	}

	//create action method for password
	public void enterpassword(String pwd) { ////in method added para as string to store the pwd 

		password.clear();
		password.sendKeys(pwd);//taken weblemt to send with string emailadd
	}

	//create action method for loginbtn
	public void clickloginbtn() {
		loginbtn.click();

	}
	
	//create action method for logoutbtn
		public void clicklogoutbtn() {
			Logout.click();

		}
















}
