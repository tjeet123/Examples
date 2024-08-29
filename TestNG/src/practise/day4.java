package practise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class day4 {
	
	@Parameters({"URL","Username"})
	@Test(timeOut=40000)
	public void webLoginCarLoan(String carName, String usname)
	{
		//Selenium
		System.out.println("Web login Car loan");
		System.out.println(carName);
		System.out.println(usname);
	}
	
	@Test(groups= {"Smoke"})
	public void mobileLoginCarLoan()
	{
		//Appium
		System.out.println("Mobile login for car loan");
	}
	
	@Test(enabled=false)
	public void mobileSigoutCarLoan()
	{
		System.out.println("Mobile signout for car loan");
	}
	@Test(dependsOnMethods= {"webLoginCarLoan"})
	public void apiLoginCarLoan()
	{
		System.out.println("API login for car loan");
	}

	@BeforeMethod
	public void bfMethod()
	{
		System.out.println("I will execute before every test method in day4 class -At Class level");
	}
	@BeforeSuite
	public void bfSuite()
	{
		System.out.println("I will execute first - at suite/xml level");
	}
	@AfterMethod
	public void afMethod()
	{
		System.out.println("I will execute after every test method in day4 class -At Class level");
	}
	@BeforeClass
	public void bfClass()
	{
		System.out.println("Before executing any methods in the class -At Class level");
	}
	@AfterClass
	public void afClass()
	{
		System.out.println("After executing all the methods in the class -At Class level");
	}
}
