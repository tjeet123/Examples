package practiseProject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

public class Miscellenous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//If need to check site with expired SSL certificate
	    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	    //If need to remove all cookies after executing any function
	    driver.manage().deleteAllCookies();
	    
	    
	    //if need to remove particular cookies
	    //driver.manage().deleteCookieNamed("sessionKey");
	    //if you delete session ID cookies then session(script) should get logout, its the valid scenario
	    
		driver.get("https://www.google.com/");
		
		//To take screenshot
		//Need to change webdriver object into screenshot object
		//Need to change object behaviour to capture screenshot
		//WE can change that by casting webdriver with method called takescreenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//Its method to copy file from source object to local machine
		FileUtils.copyFile(src,new File("D:\\SelScreenshots\\screenshot.png"));
		
	}

}
