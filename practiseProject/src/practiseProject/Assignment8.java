package practiseProject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Click on auto suggestive box to enter text
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("ind");


		// Select the india text from the suggestion
		driver.findElement(By.xpath("//li[@class='ui-menu-item']/div[text()='India']")).click();
		
		//Verify that india is displayed or not
		boolean actualData = driver.findElement(By.cssSelector("#autocomplete")).isDisplayed();
		System.out.println(actualData);
	}
	/*or can also be present like below
	public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("http://qaclickacademy.com/practice.php");
    driver.findElement(By.id("autocomplete")).sendKeys("ind");
    Thread.sleep(2000);
    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
    driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
   System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value")); 
}*/
}
