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
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinkPractise {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a = new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.cssSelector("table.gf-t a"));
		
		for(WebElement link : links)
		{
			String url = link.getAttribute("href");
			
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			a.assertTrue(respCode<400, "The link with text: " +link.getText()+ " is broken with code: " +respCode);
			
//			if(respCode>400)
//			{
//				System.out.println("The link with text: " +link.getText()+ " is broken with code: " +respCode);
//				Assert.assertTrue(false);
//			}
		}
		a.assertAll();
	}

}
