package practiseProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "jitendra";
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//instead of above code we can also call method
		String actualPassword = getPassword(driver);

		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// Enter username
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		// Enter password
		driver.findElement(By.name("inputPassword")).sendKeys("test@123");
		// Click on signin button
		driver.findElement(By.className("signInBtn")).click();

		// Print error in console
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// Click on forgot password link
		driver.findElement(By.linkText("Forgot your password?")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Name']")));

		// Enter name
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		// Enter email
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@gmail.com");
		// Clear email text
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		// Enter again email
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test@gmail.com");
		// Enter phone no.
		// For child elements
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("745123690");
		// xpath with tag travels from parent to child
		// driver.findElement(By.xpath("//form/input[3]")).sendKeys("745123690");

		// Click on reset login
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		//Same thing can be done by creating method
		// Get validation message
//		String validation = driver.findElement(By.cssSelector("p.infoMsg")).getText();
//		//Split the string through "'" to get password
//		String[] value = validation.split("'");
////		System.out.println(value[1]);
//		//Store the password in string
//		String actualPassword = value[1];

		
		Thread.sleep(2000);
		//Click on go to login button
		// parent to child traverse using xpath
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

		// Wait till the page loads
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#inputUsername")));
		// clear content which is previously added in username
		driver.findElement(By.cssSelector("#inputUsername")).clear();
		// Again enter username
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);

		// clear content which is previously added in password
		driver.findElement(By.cssSelector("input[type*='pass']")).clear();
		

				
		// how to get dynamic value of attribute through regular expression for
		// cssSelector
		//Entered the password which we got from forgot password validation
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(actualPassword);

		//Click on sign in button
		// In locators if you are selecting classname and there is some in value then
		// you can give only one value
		// If u are taking customize locator then have to select whole value
		// regular expression with xpath
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		// Thread.sleep(2000); //or
		//Wait for Welcome page to load 
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login-container']/h2")));
		
		//Get the text of successful message
		System.out.println(driver.findElement(By.tagName("p")).getText());
		// Compare the successful message
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

		// Compare the name header
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/h2")).getText(),
				"Hello " + name + ",");

		Thread.sleep(5000);
		//Click on logout button
		driver.findElement(By.cssSelector(".logout-btn")).click();
		// u can identify button through text through xpath
		// driver.findElement(By.xpath("//button[text()='Log Out']").click();
		// driver.findElement(By.xpath("//*[text()='Log Out']")).click();

		driver.quit();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		//Click on forgot password link
		driver.findElement(By.cssSelector(".forgot-pwd-container a")).click();
		//Click on reset login button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
		//To get password text
		String expectedPassword = driver.findElement(By.cssSelector("p.infoMsg")).getText();
		String[] password = expectedPassword.split("'");
		String orginalPassword = password[1];
		return orginalPassword;
	}

}
