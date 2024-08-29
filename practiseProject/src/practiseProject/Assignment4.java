package practiseProject;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
				
		//Click on multiple window
		driver.findElement(By.xpath("//li/a[@href='/windows']")).click();
		
		//Click on the link
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		//invoke window
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentId = it.next();
		String childId = it.next();
		
		//move to child window
		driver.switchTo().window(childId);
		//to get text from the child window
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
		
		//move to parent window
		driver.switchTo().window(parentId);
		
		//to get text from parent window
		System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
	}

}
