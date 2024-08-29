package practiseProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DemoSite1 {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		
	
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mark");
		driver.findElement(By.name("lastname")).sendKeys("Austin");
		
		//To close add pop-up & cookies pop-up
		driver.findElement(By.cssSelector("span.ezmob-footer-close")).click();
		driver.findElement(By.id("cookieChoiceDismiss")).click();
		
		driver.findElement(By.id("sex-0")).click();
		driver.findElement(By.xpath("//input[@value='7']")).click();
		driver.findElement(By.id("datepicker")).sendKeys("02/12/2024");
		driver.findElement(By.cssSelector("input[value='Manual Tester']")).click();
		
		driver.findElement(By.xpath("//input[@value='Selenium Webdriver']")).click();
		//Static dropdown
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='continents']"));
		
		Select dropdown = new Select(staticDropdown);
		//dropdown.selectByIndex(2);
		dropdown.selectByVisibleText("Antartica");
		System.out.println(dropdown.getFirstSelectedOption().getText());


		
		//This coding is incomplete as there are same image and multi select dropdown example
		
		//driver.quit();
	}

}
