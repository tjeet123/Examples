package practiseProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class ScrollingDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Need to cast the driver
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		
		List<WebElement> value = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		
		for(int i=0;i<value.size();i++)
		{
			 sum = sum + Integer.parseInt(value.get(i).getText());
		}
		
		System.out.println("Total value is: "+sum);
		//Convert string to integer
		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		
		if(sum==total)
		{
			System.out.println("Both sum & total matches");
		}
		else
		{
			System.out.println("Both sum & total doesnot matches");
		}
		//Assert.asserEquals(sum , total);
	}

}
