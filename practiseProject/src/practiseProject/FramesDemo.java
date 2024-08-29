package practiseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesDemo {
	
	public static void main (String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//to get count of iframe in the webpage
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//move to frame in webpage
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		//Also one can move to frame through frame index
		driver.switchTo().frame(0);
		
		//drag and drop webelement through action class
		Actions a = new Actions(driver);
		// to get drag object as webelement
		WebElement source = driver.findElement(By.id("draggable"));
		//to get drop object as webelement
		WebElement target = driver.findElement(By.id("droppable"));
		//to perform drag & drop 
		a.dragAndDrop(source, target).build().perform();
		
		//move to actual webpage otherwise it would remain in frame and nothing would be perform of webpage
		driver.switchTo().defaultContent();
	}

}
