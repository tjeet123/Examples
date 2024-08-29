package practiseProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practical1_Lily {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
	
	//	Download file in specific l		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", "D:\\SelDownload"); 
		options.setExperimentalOption("prefs", prefs);

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.lilyanncabinets.com/");
		
		Thread.sleep(25000);
		  
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext())
		{
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window

//		Now you are in the popup window, perform necessary actions here
//      Closing the pop-up by clicking on close button
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='needsclick needsclick6 klaviyo-close-form kl-private-reset-css-Xuajs1']")).click();
		Thread.sleep(3000);

//		Moved to main window and scrolled to bottom of the page & click on footer link to open pop-up
		driver.switchTo().window(parentWindowHandler);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,15000)");

		driver.findElement(By.cssSelector(".design-catalog")).click();

		Thread.sleep(3000);
//		Now you are in the popup window, perform necessary actions here
//		Add necessary field and click on button to download zip folder
		driver.switchTo().window(subWindowHandler); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='current_selling_0']")).click();

		driver.findElement(By.xpath("//label[@for='own_program_0']")).click();

		// If there is any scroll in the pop-up
		// js.executeScript("document.querySelector('.modal-content').scrollTop=1000");

		driver.findElement(By.xpath("//input[@name='inf_field_Email']")).sendKeys("jitendra@commercepundit.com");

		driver.findElement(By.xpath("//button[@id='2020button']")).click();
		

		Thread.sleep(3000);
		System.out.println("File got downloaded");
		

	}

}
