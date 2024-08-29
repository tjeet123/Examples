package practiseProject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;




public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//broken URL
		//Step 1 - Is to get all urls tied up to the links using Selenium
		//Java method will call URL's and gets you the status code
		//if status code is >400 then that url is not working (link which tied up to url is broken)
		
		
		List<WebElement> links = driver.findElements(By.xpath("//li[@class='gf-li']/a"));
		//Soft assertion
		//Script would not stop when get failure in soft assertion but in hard assertion would stop
		SoftAssert a = new SoftAssert();
		
		for(WebElement link: links)
		{
			String url = link.getAttribute("href");
			//It comes from URL class
			//Cast it with parent class
			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			
			conn.setRequestMethod("HEAD");
			conn.connect();
			//It will give you response code of url like 200,404,etc.
			int resCode = conn.getResponseCode();
			System.out.println(resCode);
			
		// Below line would check for failure and store it 
			a.assertTrue(resCode < 400,"The link with text" +link.getText() +"is broken with code" +resCode);
		
			
//			if(resCode > 400)
//			{
//			
//				System.out.println("The link with text" +link.getText() +"is broken with code" +resCode);
//			}
			
		}
		//This below line will pass your assert, it will catch all failure but it would not report if you miss below line
		a.assertAll();
	}
	

}
