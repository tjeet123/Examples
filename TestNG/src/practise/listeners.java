package practise;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//ITestListener interface which implements testng listeners
public class listeners implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("I successfully executed Listeners Pass code");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot code 
		//response if API is failed
		//System.out.println("I failed executed Listeners Pass code");
		//which test case it got failed
		System.out.println("I failed executed Listeners Pass code: " +result.getName());
		//When you catch listener how do you know test case name
		//We can have class called as ITestresult, this class describe the results of a test with ITestresult class
		// Listener we are implementing as ITestlistener when u say result. then there are many method from it getName print your testcase name
		//So when u are working in real code will use this on test failure to capture screenshot of selenium webdriver port

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
		
	}
	
}
