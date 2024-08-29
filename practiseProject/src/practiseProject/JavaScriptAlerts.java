package practiseProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String text = "Jitendra";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Enter the name in text box Switch To Alert Example
		driver.findElement(By.cssSelector("[id='name']")).sendKeys(text);
		
		//Click on Alert button
		driver.findElement(By.id("alertbtn")).click();
		
		//Get the text of pop-up
		System.out.println(driver.switchTo().alert().getText());
		
		//Click on ok button of javascript pop-up
		driver.switchTo().alert().accept();
		//Thread.sleep(5000);
		//Click on confirm button 
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		//Get the text of other pop-up
		System.out.println(driver.switchTo().alert().getText());
		
		//Click on cancel button of javascript pop-up
		driver.switchTo().alert().dismiss();
		
	}

}
