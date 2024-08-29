package practiseProject;

import static org.openqa.selenium.support.locators.RelativeLocator.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeLoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Required selenium 4 and above
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement email = driver.findElement(By.cssSelector("[name='email']"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).above(email)).getText());
		
		//relative locator do not support flex element
		//its flex element, so it will not support that element
		//it would identify subsequent input in DOM
		WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		WebElement icecreamLabel = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(icecreamLabel)).click();
		
		WebElement rbt = driver.findElement(By.id("inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rbt)).getText());
		
		
	}

}
