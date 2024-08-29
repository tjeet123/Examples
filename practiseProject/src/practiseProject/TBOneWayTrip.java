package practiseProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TBOneWayTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//Its one way trip booking
		//Click on departure city dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		//Select the city from dropdown
		driver.findElement(By.cssSelector("a[text='Chennai (MAA)']")).click();
		
		//Seclect the city from arrival dropdown
		//Here we will create xpath with parent child reference as multiple instances found
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Delhi (DEL)']")).click();
		
		//Click on departure date calendar
		driver.findElement(By.name("ctl00$mainContent$view_date1")).click();
		
		//Verify arrival dropdown is disable or not
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			Assert.assertTrue(true);
			System.out.println("Its disabled");
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		//Select current date from calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
	
		//Click on passenger dropdown
		driver.findElement(By.id("divpaxinfo")).click();
		
		//Wait for dropdown to open
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnclosepaxoption")));
		
		//Select 3 adults & 2 child
		for(int i=1;i<3;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			driver.findElement(By.id("hrefIncChd")).click();
		}
		//Click on done button in dropdown
		driver.findElement(By.id("btnclosepaxoption")).click();
		//To verify what we have selected is getting displayed
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "3 Adult, 2 Child");
		//Print the text of dropdown
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		//Select currency dropdown
		WebElement currency= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select s = new Select(currency);
		s.selectByValue("USD");
		//to verify it has displayed selected value or not
		System.out.println(s.getFirstSelectedOption().getText());
		
		//To verify what value it returns before clicking on checkbox
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		//Check mark check-box
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
		//To verify what value it returns after clicking on checkbox
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		//To get the count of check-boxes
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		//click on search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
	}

}
