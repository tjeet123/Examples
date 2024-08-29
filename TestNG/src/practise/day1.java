package practise;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class day1 {

	@AfterSuite
	public void afSuite()
	{
		System.out.println("I will execute last - at suite/xml level");
	}
	@AfterTest
	public void lastexecution()
	{
		System.out.println("I will execute last - at defined xml level");
	}
	@Test
	public void demo()
	{
		System.out.println("Hello");
		Assert.assertTrue(false);
	}
	@Test
	public void demo1()
	{
		System.out.println("Bye");
	}
}
