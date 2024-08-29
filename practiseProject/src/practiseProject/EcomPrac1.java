package practiseProject;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcomPrac1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//It would have effect at global level
		//It would continously ping in DOM and if element is loaded before time then it would get executed 
		//and test would run further
		//Readable code -Ad
		//Performance issue are not caught -Disadv
		String[] Orgname = { "Brocolli", "Cucumber", "Beetroot" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		Thread.sleep(3000);
		//Created method so code seem simple(cleaner) and doesnot look clumsy
		//It is one kind of utility CALLED add items it accepts array of item and add to cart
		Additems(driver,Orgname);

		//Click on mini cart icon
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		//Click on proceed to checkout button
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		
		//Identify the promocode text box and add promocode
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		//click on promocode apply button
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//Explicit wait
		//Its used to target specific element
		//wait is applied only as targeted element, so no performance issue -Ad
		//More code -Disadv
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		//To check promocode is successfully applied or not
		String successMsg = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		if(successMsg.equalsIgnoreCase("Code applied ..!"))
		{
			System.out.println("Coupon code successfully applied");
		}else
		{
			System.out.println("Coupon code is not applied");
		}

		//click on place order button
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	
		WebElement drp = driver.findElement(By.xpath("//select"));
		Select dropdown = new Select(drp);
		dropdown.selectByValue("India");
		
		//To click on agree for T&C
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		
		//Click on proceed button
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	}

	public static void Additems(WebDriver driver, String[] Orgname )
	{
		int j = 0;
		List<WebElement> proName = driver.findElements(By.cssSelector("h4.product-name"));
		
		int proCount = proName.size();
		for (int i = 0; i < proCount; i++) {
			String[] name = proName.get(i).getText().split("-");
			// Format it to get actual vegetable name
			String nm = name[0].trim();
			// Check whether name you extracted is present in array or not
			// Convert array into arrayList for easy search

			// Declaring first array will save memory, as Array List consume more memory
			// So that why we convert array into arrayList at run time

			List itemNeeded = Arrays.asList(Orgname);

			if (itemNeeded.contains(nm)) {
				// j is kept to count how many times condition is in "if" loop
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == Orgname.length) {
					break;
				}

			}
		}
	}
}
