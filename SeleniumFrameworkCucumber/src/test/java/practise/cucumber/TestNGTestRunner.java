package practise.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Cucumber: Here testng is only used for running(execution) as cucumber cannot run on it own
//To run ur cucumber file u have to ultimately depend upon testng or junit runners
//U cannot use testng features in cucumber

//Need to provide lots of option to testrunner and can be provide by defining below tag
//First need to provide path of feature file & also provide path of step definition through glue to testrunner
//Default output of cucumber would be in encoded format it would not be readable
//So mono chrome can be used which will give result in readable format
//How do u want to generate the report: If u want in html then need to pull that plugin
//and need to provide path where to store that file in form of (value), so target folder would be created
//Default cucumber would not able to scan testng assertions or testng librabries, so testng guys created one class
//called AbstractTestNGCucumberTests then extend it  


//If you want to run specific test then u can provide tags in testrunner @Regression

@CucumberOptions(features="src/test/java/practise/cucumber", glue="practise.stepDefinition",
monochrome=true,tags = "@Regression",plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	//How to run test, in cucumber terminology means running the feature file
	//There is something called test runner
	//What type of runner want to create? junit or testng
		//Depends on what type of project its supports
		//If in code there are assertion then its testng, as its driven by testng then use testng
		
//Interview quest: How do u decide which runner need to use?
	//That depend upon what type of assertion are there in code if there are testng assertion then use testng runner
	//or use junit runner
}
