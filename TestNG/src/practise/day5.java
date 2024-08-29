package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day5 {

	@Test
	public void mobileLoginJewelleryLoan()
	{
		System.out.println("Mobile login for jewellery loan");
	}
	
	@Test(dataProvider="getData")
	public void webLoginJewelleryLoan(String username, String password)
	{
		System.out.println("Web login for jewellery loan");
		System.out.println(username);
		System.out.println(password);
	}
	@Test
	public void apiLoginJewelleryLoan()
	{
		System.out.println("API Login for jewellery loan");
	}
	@DataProvider
	public Object[][] getData()
	{
		//Define how many times you have to run data set in first bracket and how many values you are calling set in second bracket
		Object[][] data = new Object[3][2];
		
		//set1
		data[0][0]="firstusername";
		data[0][1]="firstpassword";
		
		//set2
		data[1][0]="secondusername";
		data[1][1]="secondpassword";
		
		//set3
		data[2][0]="thirdusername";
		data[2][1]="thirdpassword";
		
		return data;
	}
	//How do u achieve parameterization
	//2 Ways. Drive data from testng xml file and drive data and parameterization using dataProvider annotation
}
