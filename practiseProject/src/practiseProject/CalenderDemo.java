package practiseProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//This program is to select specific future date from the date calendar 
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.path2usa.com/travel-companion/");
		
		//To scroll the screen
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1100)");
		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("/html/body/ins[2]/div[1]//ins/span/svg/path")).click();
//		Thread.sleep(5000);
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		
		//while loop will keep on executing until it becomes false 
		while(!driver.findElement(By.xpath("//span[@class='cur-month']")).getText().contains("September"))
		{
			driver.findElement(By.cssSelector("span.flatpickr-next-month")).click();
			Thread.sleep(1000);
		}
		
		List<WebElement> days = driver.findElements(By.xpath("//span[@class='flatpickr-day ']"));
		
		int count = days.size();
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).getText();
			if(text.equalsIgnoreCase("21"))
			{
				driver.findElements(By.xpath("//span[@class='flatpickr-day ']")).get(i).click();
				break;
			}
			
		}
	}

}
