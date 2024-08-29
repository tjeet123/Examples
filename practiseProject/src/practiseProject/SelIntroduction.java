package practiseProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SelIntroduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Chrome Browser
//		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		//Firefox Browser
//		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.33.0-win64\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		//Edge Browser
		System.setProperty("webdriver.edge.driver", "D:\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	
     }
}