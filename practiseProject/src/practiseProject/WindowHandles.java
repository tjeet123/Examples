package practiseProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		//to click on top link
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		//It will open in new tab or window
		//First need to invoke window
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		//Move to child window
		driver.switchTo().window(childId);
		//Get string and separate particular email id from it
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4];
		System.out.println(emailId);
		
		//Move to parent window
		driver.switchTo().window(parentId);
		//Enter email id in username
		driver.findElement(By.cssSelector("#username")).sendKeys(emailId);
		
	}

}
