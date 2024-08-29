package practiseProject;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CompareStringVthStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture all webelements into List
		List<WebElement> newList = driver.findElements(By.xpath("//tr/td[1]"));
		
		//capture text of all webelements into new (original)list
		List<String> originalList = newList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the original list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		//compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		//need to use condition method then need to apply filter operation
		//need to get price of beans
		
		List<String> price = newList.stream().filter(s->s.getText().contains("Beans")).
		map(s->getVeggePrice(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		
	}

	private static String getVeggePrice(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
}
