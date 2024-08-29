package practise.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRDemo {
	
ExtentReports extent;
	
	@BeforeMethod
	public void config()
	{
		//Need to know 2 class for extend report: 1. ExtentReports 2. ExtentSpark Reporter
		//First create object for ExtentSpark Reporter
		//Need to create folder in project dynamically
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		//This reporter class expect path, where your report should be created
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//To change the heading of the report
		reporter.config().setReportName("Web Automation Results");
		//To change the title of report
		reporter.config().setDocumentTitle("Test Results");
		
		
		//Its main class and It will drive all reporting executions
		extent = new ExtentReports();
		//Now u have to attach report which u created with extentSparkReporter
		//Extent Reports is responsible to create and consolidate all ur test execution
		//Extent SparkReporter is helper class which is helping to create some configuration and will finaling report to main class
		extent.attachReporter(reporter);
		//Tester name can be give through extent reports class
		extent.setSystemInfo("Tester","Jitendra");
		
	}
	@Test
	public void initialDemo()
	{
		//How testcase would be link with report
		// Need to declare report object at global level so we can access it in this method
		//ExtentTest test = extent.createTest("Initial Demo");
		ExtentTest test = extent.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		
		System.out.println(driver.getTitle());
		
		//Try to fail test just catch the object by creating 
		//When u create test automatically one object is created for your complete test method, u can catch the object ExtentTest test = extent.createTest("Initial Demo");
		// This object would be responsible to lisenting and report all the happening back to extent report
		test.fail("Result donot match");
		//Once test is done then at last need to write flush. It will be notified test is done and it will no more start monitoring
		//If there are 5 test case then after 5 case u can flush which will create report otherwise it would in listening mode
		extent.flush();
	}

}
