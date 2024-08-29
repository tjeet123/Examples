package practise;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class parentClassInheritence {
	//Inheritance means you can acquire the properties of parent class into child class
	//Inheritaring from our parent before executing it would check parent class whether there is any before method then it would execute that method first
	public void firstMethod()
	{
		System.out.println("I am here");
	}
	@BeforeMethod
	public void beforeRun()
	{
		System.out.println("Run me first");
	}
	
	@AfterMethod
	public void afterRun()
	{
		System.out.println("Run me last");
	}
}
