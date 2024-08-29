package practiseProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewWindow {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Invoking new tab in browser
		driver.switchTo().newWindow(WindowType.TAB);
		//Open new window
		//driver.switchTo().newWindow(WindowType.WINDOW);
		
		//To check how many window(tab) are currently open by selenium
		//All windows/tab id would store in set data structure so its return type is set
		Set<String> handles = driver.getWindowHandles();
		
		//to iterate windows (to count window id and move accordingly)
		Iterator<String> it = handles.iterator();
		//Moves to parentWindow
		String parentWindow = it.next();
		//Move to child window
		String childWindow = it.next();
		//Switch to child window
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		
		//Wait till page load
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='logo']")));
		
		//Get the course name
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(3).getText();
		
		//Move to partentWindow
		driver.switchTo().window(parentWindow);
		
		//Add text to emailfield in parent window
		//driver.findElement(By.cssSelector("[name='email']")).sendKeys(courseName);
		
		WebElement email = driver.findElement(By.cssSelector("[name='email']"));
		email.sendKeys(courseName);
		
		//to get screenshot
		File file = email.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("sample.png"));
		
		
	}
	

}
