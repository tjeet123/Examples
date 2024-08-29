package practiseProject;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		//To add username in textbox
		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		//To add password in textbox
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
		
		driver.findElement(By.xpath("//span[text()=' User']")).click();
		
		//Store your parent window
		String parentWindowHandler = driver.getWindowHandle();
		String childWindowHandler = null;
		
		//Get all window handles
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		
		while(iterator.hasNext())
		{
			childWindowHandler = iterator.next();
		}
		//Move to pop-up
		driver.switchTo().window(childWindowHandler);
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-content")));
	
		
		//Click on pop-up okay button
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		
		//Move to main window
		driver.switchTo().window(parentWindowHandler);
		
		//Select dropdown
		WebElement ageGrp = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdown = new Select(ageGrp);
		dropdown.selectByValue("stud");
		
		//click on t&c
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		
		//click on sign-in btn
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		
		//Shop-name visible
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.my-4")));
		
		//To check landed on correct page or not
		String title = "ProtoCommerce";
		String pageTitle = driver.getTitle();
		if(pageTitle.equalsIgnoreCase(title))
		{
			System.out.println("Redirected to correct page");
		}
		else
		{
			System.out.println("Redirected to incorrect page");
		}
		
		//To add all the items from the PLP
		List<WebElement> products = driver.findElements(By.cssSelector("button.btn"));
		for(int i=0;i<products.size();i++)
		{
			products.get(i).click();
		}
		
		//Click on checkout button
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
		
	}

}
