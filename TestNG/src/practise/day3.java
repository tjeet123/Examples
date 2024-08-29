package practise;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class day3 {

	//Parameters would be for below method only and if you want to call for all method then need to mention above all methods
	@Parameters({"URL"})
	@Test
	public void WebLoginHomeLoan(String urlName)
	{
		//Selenium
		System.out.println("webloginhome page");
		System.out.println(urlName);
	}
	
	@Test
	public void mobileLoginHomeLoan()
	{
		//Appium
		System.out.println("Mobile Login Home page");
	}
	
	@Test
	public void mobileSignInHomeLoan()
	{
		//Appium
		System.out.println("Mobile Signin Home page");
	}
	
	@Test
	public void mobileSignoutHomeLoan()
	{
		//Appium
		System.out.println("Mobile Signout Home page");
	}
	
	@Test(groups={"Smoke"})
	public void APILoginHomeLoan()
	{
		//Rest API Automation
		System.out.println("API Login Home page");
	}
}
