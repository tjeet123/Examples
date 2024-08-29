package practise;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day2 {

	@Test(groups= {"Smoke"})
	public void ploan()
	{
		System.out.println("Great work");
	}
	//Before test and after test will execute as per the test classes or test in the xml file
	//Before suite and after suite will execute as per xml file (at the top & bottom of all classes or methods)
	//Before method and after method, if the class there are 4 methods then
	//Before method will execute before every method means 4 times
	//BM -> then 1st method -> BM -> 2nd method -> BM -> 3rd method -> BM -> 4th method
	//After method will execute after every method of any particular class
	//Before test & before suite are xml level and before class & before method are at class level
	//In testng executing of the methods depend on alphabetic order of the methods
	//If there are 100 test cases and need to only run 40 test cases - then one can make use of groups in testng
	//dependsOnMethod - and method name: Will stop particular method to execute till its depended method is not executed
	
	//If there is any bug which is reported for particular method and yet its not fix, so one can skip that method from execution
	//by adding "enabled=false" in test annotation, so that method would skip from execution
	//If there are few err in app and i dont want framework to trigger that : I will enable to it as false with help of testng helper attribute
	
	//If there is any method/service taking time to load but execution would not wait that much time so make use of timeOut(it would accept time is miliseconds)
	
	//Parameters, global data which would be used frequently can be parameterized, so it can to called directly: it would work at method level and need to
	//call individually for each method. It can be used at global(suite) level or class(test) level
	//One can parameterize with multiple values
	//dataProvider is used at method level for parameterization
	//How do u achieve parameterization
	//2 Ways. Drive data from testng xml file and drive data and parameterization using dataProvider annotation
	
	@BeforeTest
	public void excuteLast()
	{
		System.out.println("I will execute first - at defined xml level");
	}
}
