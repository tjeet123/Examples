package practiseProject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CSVthSPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// To sort grid order
		driver.findElement(By.xpath("//th[@role='columnheader'][1]")).click();

		// to select the first coloumn of grid
		List<WebElement> element = driver.findElements(By.xpath("//tr/td[1]"));

		// capture text of all webelements into new
		List<String> originalList = element.stream().map(s -> s.getText()).collect(Collectors.toList());

		// sort on the original list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		List<String> price;

		do {
			// Renamed it as webelement(element) is already available
			List<WebElement> row = driver.findElements(By.xpath("//tr/td[1]"));

			// to get next coloumn of grid for specific row "Beans" and its specific price
			price = row.stream().filter(s -> s.getText().equals("Rice")).map(s -> getVeggePrice(s))
					.collect(Collectors.toList());
			price.forEach(s -> System.out.println(s));
			
			//To check price row is got or not otherwise move to next page
			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}

		} while (price.size() < 1);

	}

	private static String getVeggePrice(WebElement s) {
		// TODO Auto-generated method stub
		String actualPrice = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return actualPrice;
	}

}
