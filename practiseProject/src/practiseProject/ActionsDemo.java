package practiseProject;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		Actions a = new Actions(driver);
		
		WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		//to type text in capital letter and select that text
		a.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		WebElement signIn = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
		//To move mouse to specific location. Also right click on it
		a.moveToElement(signIn).contextClick().build().perform();
		
		
				
		
		

	}

}
