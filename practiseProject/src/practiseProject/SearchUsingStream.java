package practiseProject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;
import net.bytebuddy.matcher.FilterableList;

public class SearchUsingStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Search Rice in textbox
		driver.findElement(By.cssSelector("input#search-field")).sendKeys("Rice");
		
		//To get search result in grid
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		//To check search result contains search text (Rice)
		List<WebElement> filteredList = veggies.stream().filter(s->s.getText().contains("Rice"))
				.collect(Collectors.toList());
		
		//To compare actual & expected result with size
		Assert.assertEquals(veggies.size(), filteredList.size());
		
		
		
	}

}
