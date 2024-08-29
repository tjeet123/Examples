package practiseProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Add name field
		driver.findElement(By.name("name")).sendKeys("Jitendra");
		
		//Add Email
		driver.findElement(By.name("email")).sendKeys("jitendra@gmail.com");
		
		//Add password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("12345678");
		
		//Click on checkbox
		driver.findElement(By.id("exampleCheck1")).click();
		
		//Select gender from dropdown
		WebElement gender = driver.findElement(By.id("exampleFormControlSelect1"));
		Select s = new Select(gender);
		s.selectByIndex(0);
		
		//Click on radio button for employee status
		driver.findElement(By.id("inlineRadio1")).click();
		
		//Add DOB
		driver.findElement(By.name("bday")).sendKeys("01-01-1991");
		
		//Click on submit button
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		
		//Print success message
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert-dismissible']")).getText());
	}

}
