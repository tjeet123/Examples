package practise.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login2orderFlowTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/client");
		
		//Add email in login page
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("jitendra@gmail.com");
		//add password
		driver.findElement(By.id("userPassword")).sendKeys("Test@123");
		//Click on login button
		driver.findElement(By.name("login")).click();
		
		//Here we would apply explicit wait as it take some time to load page
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		//To get products from listing page
		List<WebElement> product = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = product.stream().filter(s->
		s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		//Here we have taken prod webelement and not driver, so it scope would get limited to particular product
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		//Loader to disappear
		w.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//Successful message to appear
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-success")));
		
		//Click on cart button
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
				
				
		//Compare product in the cart page
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cart h3"));
		
		//As we don't need of any string in response we just need to check productName is matching or not, so we have
		//make use of anyMatch instead of filter for stream
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		

		//Click on checkout button
		driver.findElement(By.cssSelector(".subtotal button")).click();
		
		
		//Suggestive dropdown
//		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
//		
//		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".list-group")));
//		//get suggestion
//		List<WebElement> country = driver.findElements(By.cssSelector(".list-group span"));
//		
//		for(int i=0;i<country.size();i++)
//		{
//			String result = country.get(i).getText().trim();
//
//			if(result.equals("India"))
//			{
//				country.get(i).click();
//				break;
//			}
//				
//		}
		
		//Suggestive box with different method
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".list-group")));
		//cssselector(".ta-item:nth-of-type(2)")
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		
		//click on place order
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		//Verify successful message
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		//Get order id
		String[] orderid = driver.findElement(By.cssSelector("label.ng-star-inserted")).getText().split(" ");
		String ord =orderid[1]; 
		
		//click on order history page
		driver.findElement(By.cssSelector("label[routerlink*='myorders']")).click();
		
		//Get order id
		List<WebElement> ordersList = driver.findElements(By.cssSelector(".ng-star-inserted th:first-child"));
		
		for(int i=0;i<ordersList.size();i++)
		{
			String orderNo = ordersList.get(i).getText();
			
			if(orderNo.equals(ord))
			{
				driver.findElement(By.cssSelector(".btn-danger")).click();
				break;
			}
		}
		
		//Get successful message
		String deleteMessage = driver.findElement(By.cssSelector(".toast-message")).getText();
		System.out.println(deleteMessage);
		
		
	}

}
