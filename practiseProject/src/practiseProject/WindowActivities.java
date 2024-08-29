package practiseProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//to open window in maximize mode
		driver.manage().window().maximize();
		
		driver.get("https://google.com");
		//Navigate When you are already on selenium browser automation
		//Difference in synchronization
		//get method: it will wait till all the component are fully loaded (Selenium will pause(wait) till the page is fully loaded)
		//Navigate to method:: Selenium will not wait - if only image is loaded it will continue
		driver.navigate().to("https://rahulshettyacademy.com/");
		//It will use browser back button so will redirect to google.com
		driver.navigate().back();
		//It will user browser forward button so will redirect to rahulshetty website
		driver.navigate().forward();
	}

}
