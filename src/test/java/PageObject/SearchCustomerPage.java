package PageObject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver ldriver; //create webdriver local object outside constructor

	public SearchCustomerPage(WebDriver rdriver) {//constructor & webdriver n obj is passed

		ldriver=rdriver; //local obj=remote obj of webdriver

		PageFactory.initElements(rdriver, this);

	}


	///use @find by method for WebElement for emailid
	@FindBy(id="SearchEmail")
	WebElement emailadd;

	///use @find by method for WebElement for searchbtn
	@FindBy(id="search-customers")
	WebElement searchbtn;

	///use @find by method for WebElement for searchresult
	@FindBy(xpath = "table[@class='table table-bordered table-hover table-striped dataTable']")
	WebElement searchresult;

	//use @find by method for WebElement for total no of rows
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable']//tbody/tr")
	List<WebElement> tablerows;

	//use @find by method for WebElement for total no of columns
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-striped dataTable']//tbody/tr[1]/td")
	List<WebElement> tablecolumns;

	//now create class of action method for WebElement 
	//for entering emailid
	public void enteremailadd(String email) { //cz of string value to be stored string para & obj is created
		emailadd.sendKeys(email); //webelemt.actionmethod in bracket (stringobj)

	}

	//for click on searchbtn
	public void clickonsearchbtn() {  //cz of btn no para is passed
		searchbtn.click();

	}

	//for searching the result
	public boolean searchresult(String email)
	{
		boolean found=false; //result not found the false

		//total no of rows in grid
		int ttlrows=tablerows.size();

		//total no of columns
		//int ttlcolumns=tablecolumns.size();  unused

		for (int i = 1; i <=ttlrows; i++) //to iterarte all the rows of the grid
		{
			//path of colums & "i" is inserted for serach from all the rows & td[2] cz our data is on second
			WebElement webelementemail=ldriver.findElement(By.xpath("//table[@class='table table-bordered table-hover table-striped dataTable']//tbody/tr["+i+"]/td[2]"));
			String actualemailadd=webelementemail.getText();

			if (actualemailadd.equals(email)) { //checking actaul email is return the expected email or not 
				found=true; //if result is found the true 

			} 

		}


		return found;
	}



}
