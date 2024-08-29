package practiseProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Scroll the screen
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");
		
		//To get count of rows for course table
		System.out.println(driver.findElements(By.cssSelector("table[name='courses'] tr")).size());
		
		//to get count of columns in course table
		System.out.println(driver.findElements(By.cssSelector("table[name='courses'] th")).size());
		
		//To print text of the 3rd row
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses'] //tr[3]/td"));
		for(int i=0;i<rows.size();i++)
		{
			System.out.println(rows.get(i).getText());
		}
		
	}
/* or can be also done like below
 import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class A3 {
public static void main(String[] args) {
// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("http://qaclickacademy.com/practice.php");
WebElement table=driver.findElement(By.id("product"));
System.out.println(table.findElements(By.tagName("tr")).size());
System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
System.out.println(secondrow.get(0).getText());
System.out.println(secondrow.get(1).getText());
System.out.println(secondrow.get(2).getText());
}} */
}
