package practise.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import practise.resources.ExtentReporterNG;

//This is one of the interface provided by testng
//This interface will always listen about your test result
public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		//before running any testng test your code control would reach first here
		//so we can keep here the line of report, to notify first to create extentreprot then go to method 
		//inside createtest need to give testcase name, to create entry to check whether testcase is pass/fail
		//how to give testcase name, here for every method result variable is passed, this variable hold the information about the test which is going to excute
		//by giving getmethod & getmethod name we are dynamically call that method name
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// If any test is success with pass, it would come here to execute
		test.log(Status.PASS, "Test Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.FAIL, "Test Failed"); //OR
		//getthrowable : It will give all the error message
		test.fail(result.getThrowable());

		//Screenshot, attach it to report
		//It will ask for testcase name, so need to set dynamically
		//Its returns path where screenshto is stored : Screenshot is stored in local path 
		String filePath = null;
		//In screenshot there is driver in basetest but here it doesnot have life, send driver as argument from basetest
		//Initially driver here also is unknown, there is no life to driver
		//AS result all the information about testcase, similarly all the information are send in result variable, 
		//To each testcase we are assigning one driver, through beforeMethod in basetest as driver = intilizeDriver();
		//That driver information would also be stored in result variable
		
		try {
			//here from result u are getting the information about class(which of xml file) then getting information abt real class
			//means it will go to java file where test is written, from that class whatever field is using driver to get it.
			//that field is received to get life to screenshot
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			//Its generic expection and its parent class of all exceptions
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			//IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
			e1.printStackTrace();
		}
		try {
			 filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//First argument we have send the name to the path, second argument name of how to show in report with name
		//Below line take the screenshot from local system and attach it to your report
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//Entire execution of all testcases are done this is final method which will execute at last
		extent.flush();
		
	}


}
