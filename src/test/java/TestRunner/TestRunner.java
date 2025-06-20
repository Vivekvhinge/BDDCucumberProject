package TestRunner; // Keep your package name as is

import io.cucumber.testng.AbstractTestNGCucumberTests;  //for session 9 added this import

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;  [removed for testng refer session 9]
//import io.cucumber.junit.CucumberOptions; [removed for testng refer session 9]

import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)  //step1   [removed for testng refer session 9]


@CucumberOptions(  //step2
		//features = "src/test/resources/Features",  // <-- path 
		//features = "src/test/resources/Features", // multiple :to run it just remove file name after feature folder
		features = "src/test/resources/Features/LoginFeature.feature", // <--in that u can select a feature file to run 
		//	features = {"src/test/resources/Features/LoginFeature.feature","src/test/resources/Features/Customer.feature"}, //<-- to run specific feature files 
		// Ensure you use FORWARD SLASHES (/) as shown, even on Windows.


		glue = "StepDefinition", // Search for steps in StepDefinition package
		//		plugin = {
		//				"pretty",
		//				"html:target/cucumber-reports/cucumber.html", //to create html report with path
		//				"json:target/cucumber-reports/cucumber.json",//
		//				"rerun:target/cucumber-reports/rerun.txt",
		//				"junit:target/cucumber-reports/xml.xml"
		//		},

		//session 10
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true,// to read the output options in console in readable format ,if set as false then not able to read properly 
				//tags="@sanity" , //it will run/execute scenarios under @sanity tags only 
				dryRun = false,  //it will check the mapping between feature file & steps definition file ,checks that in feature file written step is implemented in step denition with method if true 
				publish = true
		)



public class TestRunner  extends AbstractTestNGCucumberTests{
	// ... this class will be empty
}