package practiseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class Assignment1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Check the first checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		//To verify first checkbox is selected or not
		//System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//Un-Check the first checkbox
		driver.findElement(By.id("checkBoxOption1")).click();
		//To verify first checkbox is unchecked or not
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//To get count of all check-box
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}

}
