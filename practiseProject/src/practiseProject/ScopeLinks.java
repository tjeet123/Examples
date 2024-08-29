package practiseProject;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScopeLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//1. Give me count of links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Get the count of links present in the footer section (Limiting webdriver scope)
		//System.out.println(driver.findElements(By.xpath("//table[@class='gf-t'] //ul/li")).size());
		//First need to create one webelement which will act as sub-driver of that webpage  (Limiting webdriver scope)
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		
		//now count in links with the help of sub-driver
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3. Needed link count of only first column in footer section
		WebElement firstColumnFooterDriver = footerDriver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		System.out.println(firstColumnFooterDriver.findElements(By.tagName("a")).size());
		
		//4. Open the links of footer first column and get title of the same
		for(int i=1;i<firstColumnFooterDriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			firstColumnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLink);
			Thread.sleep(5000L);
			
		}
		
		//	Need to get title of the open tabs
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();	
		//Hasnext tells us whether next index is present or not	
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	
	}

}
