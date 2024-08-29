package practise.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import practise.pageobjects.CartPage;
import practise.pageobjects.CheckoutPage;
import practise.pageobjects.LandingPage;
import practise.pageobjects.MyOrderPage;
import practise.pageobjects.ProductCatalogue;
import practise.pageobjects.SuccessPage;

public class StadaloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";
		String countryName = "india";
		String expectedMessage = "THANKYOU FOR THE ORDER.";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//LandingPage landingPage = launchApplication();
		LandingPage landingPage = new LandingPage(driver); 
		landingPage.goTo();
		//As we have to everytime launchapplicaton for every test,so its common
		ProductCatalogue productCatalogue = landingPage.loginApplication("jitendra@gmail.com", "Test@123");
		
		List<WebElement> product = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		//Can u apply page factory within webelement.findelement?: Ans: No its not possible
		//As mini cart link is in header, so it would be used in all pages, so its placed in abstractcomponent class and can be called by any class
		//As we know that on click we would land to other page so create object of that page in that method
		CartPage cartPage = productCatalogue.moveToCartPage();

		Boolean match = cartPage.verifyProducts(productName);
		//Validation cannot go in page object files. It only has code to perform actions 
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.moveToCheckoutPage();		
						
		checkoutPage.suggestiveDropdown(countryName);
		SuccessPage successPage = checkoutPage.placeOrder();

		String confirmMessage = successPage.verifyMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(expectedMessage));
		String orderIdText = successPage.getOrderId();
		MyOrderPage orderPage = successPage.moveToOrderPage();
		
		orderPage.compareOrder(orderIdText);
		orderPage.toastMessage();	
		
	}



}
