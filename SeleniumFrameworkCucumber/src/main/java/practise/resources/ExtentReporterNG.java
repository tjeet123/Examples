package practise.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	//By putting static we can access method directly through its class name
	public static ExtentReports getReportObject()
	{
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Jitendra");
		//We need to create entries for each and every test in reports
		//If there are 100 testcases then we will not add in each any every test case the same, so there is one concept called Listeners
		return extent;
		
		
	}
	
}
