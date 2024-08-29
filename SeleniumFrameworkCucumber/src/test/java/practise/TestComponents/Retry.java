package practise.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int count = 0;
	int maxTry = 1;
	//To rerun failed flaky test
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		//When test fails it comes to this block to check, do i need to rerun again failed test
		//Here to write logic of rerun, if u want to rerun so how many times u want to rerun. Some people run it for 3 time some for 1 time
		if(count<maxTry)
		{
			//To tell rerun basically we except this method to return true, as long as this method returns true it will keep on retrying
			count++;
			return true;
		}
		//The movement it return false, it will stop retry
		return false;
	}

}
