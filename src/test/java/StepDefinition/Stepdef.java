package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.Readconfig;
import io.cucumber.java.*; // Important: Use io.cucumber.java.* for Cucumber annotations
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


//Child class of base class cz we have extended it to baseclass refer:session4
public class Stepdef extends BaseClass { //we call the method class created on pageobject by using pageobj .methodname refer session 2



	@Before
	public void Setup() { //refer session 5 [hooks :scenario hooks]
		//refer session 6 & instantiate log to this file
		log=LogManager.getLogger("StepDefinition.Stepdef");  

		//Initialize the properties class  here refer session 7
		readconfig=new Readconfig();


		//below code is in raedconfig.java file so we dont need here 
		//now create obj of fileinputstream for readonly mode to open of readconfig/configproperties file refer session 7
		//		try {
		//			FileInputStream fis=new FileInputStream("config.properties");//file name given cz in same workspace or give filepath refer session 7
		//			readconfig.load(fis); //to load the fis object refer session 7
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		} 

		//create string obj to store the readconfigs .getproperties variable value[stored in config.properties]
		//String browser=readconfig.getProperty("browser");  no need cz we created readconfig file
		String browser=readconfig.getbrowser();  //by readconfigfile & getbrowser method we will store the keyvaribale in string browser
		//		switch(browser.toLowerCase())
		//		{
		//		case "chrome":
		//
		//			WebDriverManager.chromedriver().setup();
		//			driver=new ChromeDriver();
		//			break;
		//
		//		case "msedge":
		//
		//			WebDriverManager.edgedriver().setup();
		//			driver=new EdgeDriver();
		//			break;
		//
		//		default:
		//			driver=null;
		//			break;
		//
		//
		//		}

		//launch browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); // Initialize the driver here

		//log.Level =in level as per u want change to info ,debug,warn for the logging
		log.info("log setup method is executed .....");  //log.info for displaying message refer session 6


		System.out.println("setup method executed...");

	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		// Initialize Page Objects AFTER driver is created in @Before hook
		loginpg = new LoginPage(driver);
		AddNewCustPg = new AddNewCustomerPage(driver);
		SearchCustomerPg = new SearchCustomerPage(driver);

		log.info("log launch chrome browser is executed .....");  //log.info for displaying message refer session 6
	}


	@When("User open URL: {string}")
	public void user_open_url(String url) { //url will get from feature file
		driver.get(url); //calling received url
		log.info("log url string is executed .....");  //log.info for displaying message refer session 6
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String password) { // email & pwd will get from feature file and stored in string to execute
		//with loginpg obj calling the enteremail with string parameter
		loginpg.enteremail(emailadd);

		//with loginpg obj calling the enterpassword with string parameter
		loginpg.enterpassword(password);

		log.info("log eneterd email & password is executed .....");  //log.info for displaying message refer session 6
	}

	@When("click on login")
	public void click_on_login() {
		//with loginpg obj calling the clickloginbtn to do action

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		loginpg.clickloginbtn();

		log.info("log login button is clicked .....");  //log.info for displaying message refer session 6

	}


	///login feature ////////////////
	@Then("page title should be {string}")
	public void page_title_should_be(String expectedtitle) {
		String actualtitle = driver.getTitle();


		if (actualtitle.equals(expectedtitle)) {
			log.warn("test passed: login feature : page title found .....");  //log.info for displaying message refer session 6
			Assert.assertTrue(true); //pass


		} else {
			log.warn("test failed :login feature :page title not found .....");  //log.info for displaying message refer session 6
			Assert.assertTrue(false); //fail
		}
	}

	@When("user click on log out link")
	public void user_click_on_log_out_link() {
		loginpg.clicklogoutbtn();
		log.info("log llogout button is clicked.....");  //log.info for displaying message refer session 6
	}


	////commented for SESSION 9 : AND CREATED ONE NEW CLASS OF IT CLOSESTEP/////////

	@Then("Close Browser")  
	public void close_browser() {
		// This step definition can also call driver.quit() if you prefer,
		// but typically it's handled by the @After hook for consistency.
		// If you keep this step, ensure it only quits if the driver is still active.
		// For now, let's rely on the @After hook.
		//driver.quit(); // Keep this commented if @After is handling it
	}



	////////////add new customer//////////


	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		String actualtitle = AddNewCustPg.getPageTitle();
		String expectedtitle = "Dashboard / nopCommerce administration";

		if (actualtitle.equals(expectedtitle)) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);

		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		AddNewCustPg.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		AddNewCustPg.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		AddNewCustPg.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualtitle = AddNewCustPg.getPageTitle();
		String expectedtitle = "Add a new customer / nopCommerce administration";
		if (actualtitle.equals(expectedtitle)) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);

		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {

		AddNewCustPg.enterEmail( generatemailid() + "@gmail.com"); //refer to session4 or baseclass
		AddNewCustPg.enterPassword("vivek@gmail.com");
		AddNewCustPg.enterFirstName("vivek");
		AddNewCustPg.enterLastName("hinge");
		AddNewCustPg.enterDob("6/14/2025");
		AddNewCustPg.enterCompanyName("vivekenterprise");
		AddNewCustPg.enterAdminContent("admin contenttt");
		AddNewCustPg.enterManagerOfVendor("Vendor 1");
		AddNewCustPg.enterGender("male");

	}

	@When("click on Save button")
	public void click_on_save_button() {
		AddNewCustPg.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedconfirmatiommsg) {

		String bodytagtex = driver.findElement(By.tagName("body")).getText();
		if (bodytagtex.contains(expectedconfirmatiommsg)) {
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false);
		}
	}

	/////////////////SEARCH CUSTOMER PAGE /////////
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		SearchCustomerPg.enteremailadd("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
		SearchCustomerPg.clickonsearchbtn();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedemail = "victoria_victoria@nopCommerce.com";
		Assert.assertTrue(SearchCustomerPg.searchresult(expectedemail));
	}

	//@After //commented for adding the function with different annotation
	public void teardown(Scenario sc) { //refer session 5[hooks :scenario hooks] & to capture SS we need to use scenaro class& obj in parameter
		//if condition for capturing the failed SS
		if (sc.isFailed()) //if condition when scenario is failed with true action
		{
			// step1:takeSS is class for taking SS ,instantiate with webdriver to capture
			TakesScreenshot ss = ((TakesScreenshot)driver);

			//now use fileclass to store and outputype for the SS output
			File filesource = ss.getScreenshotAs(OutputType.FILE);
			//now give filepath
			File filepathdestination = new File("C:\\Users\\Admin\\eclipse-workspace\\CucumberFramework\\Screenshots\\failedss.png");

			//copy image to filedestination ,use fileutils  use to manipulate and .copy to copy its action
			try {
				FileUtils.copyFile(filesource, filepathdestination);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Teardown method executed. Closing browser."); // Corrected print statement
		if (driver != null) { // Add a null check before quitting
			driver.quit();
		}
	}



	//SESSION 10
	//Add following @AfterStep method in step definition file to capture screenshot and attached it to extent report
	@AfterStep
	public void addScreenshot (Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs (OutputType. BYTES);
		//attach image file report (data, media type, name of the attachment) 
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	


	@BeforeStep
	public void beforestep() { //refer session 5[hooks :Step hooks]
		System.out.println("beforestep method executed...");
	}

	@AfterStep
	public void AfterStep() { //refer session 5[hooks :Step hooks]
		System.out.println("AfterStep method executed...");
		// REMOVED driver.quit(); FROM HERE. It should only be in @After
	}
}
