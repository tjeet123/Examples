package practiseProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class StaticDropdowns {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Note: To run this code check the calendar date, it should always be above current date
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		//To check before click what vaule it returns
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		// Select the trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		//To validate that return date calendar is enabled or not
		//As we click on round trip then return date calendar gets enable so no need to click on return date calendar again
		//driver.findElement(By.name("ctl00$mainContent$view_date2")).click();
		//This method will return true if it passes but sometimes this doesnot support 
		//System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());

		//Alternative of above method
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
			System.out.println("Its enabled");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		//Dynamic dropdown
		//Dynamic drpdown :: As one will select from city then only to city dropdown option would be visible
		
		// Click on from city textbox
		driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		// Select the from city
		List<WebElement> fromCity = driver.findElements(By.xpath("//div[@class='dropdownDiv']/ul/li"));
		for (int i = 0; i < fromCity.size(); i++) {
			String cityName = fromCity.get(i).getText();
			String[] actualCityName = cityName.split(" ");
			if (actualCityName[0].equalsIgnoreCase("Ahmedabad")) {
				fromCity.get(i).click();
				break;
			}
		}
		
		// select the to city (No need to click as it would directly redirect)
		driver.findElement(By.name("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();

		List<WebElement> toCity = driver.findElements(By.xpath("//div[@class='dropdownDiv']/ul/li"));
		for (int i = 0; i < toCity.size(); i++) {
			String toCityName = toCity.get(i).getText();
			String[] actualToCity = toCityName.split(" ");
			if (actualToCity[0].equals("Kochi")) {
				driver.findElements(By.xpath("//div[@class='dropdownDiv']/ul/li")).get(i).click();
				break;
			}
		}

		// Select departure date from calendar
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']")));
		//Parent-child relationship xpath
		List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar'] //td/a"));
		for (int i = 0; i < days.size(); i++) {
			String count = days.get(i).getText();
			if (count.equalsIgnoreCase("27")) {
				days.get(i).click();
				break;
			}
		}

		// Select return date from calendar
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		
		w.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//table[@class='ui-datepicker-calendar']")));
		List<WebElement> returnDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar'] //td/a"));
		for (int i = 0; i < returnDays.size(); i++) {
			String count1 = returnDays.get(i).getText();
			if (count1.equalsIgnoreCase("27")) {
				returnDays.get(i).click();
				break;
			}
		}
		
		// Select value from passengers dropdown
		// Click to open options of drpdown
		driver.findElement(By.className("paxinfo")).click();
		// Click to add more than 1 passenger from dropdown 
		int i=1;
		while(i<4)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		// Click on done button in drpdown
		driver.findElement(By.id("btnclosepaxoption")).click();
		//To validate what value did you received in dropdown
		System.out.println(driver.findElement(By.className("paxinfo")).getText());
		
		//If tag name is select than that dropdown is static dropdown
		// Select value from currency dropdown
		WebElement drpdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select sdropdown = new Select(drpdown);
		sdropdown.selectByValue("USD");
		//To verify that it has displayed USD or not
		System.out.println(sdropdown.getFirstSelectedOption().getText());
		
		//to check what value it returns before click
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		// Select radio button
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		//to check what value it returns after click
		System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		//To get count of check-boxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		// Click on search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		// Click ok on pop-up, No alert displayed
		//driver.switchTo().alert().accept();
	}

}
