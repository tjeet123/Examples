package practise.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import practise.TestComponents.BaseTest;
import practise.pageobjects.CartPage;
import practise.pageobjects.CheckoutPage;
import practise.pageobjects.MyOrderPage;
import practise.pageobjects.ProductCatalogue;
import practise.pageobjects.SuccessPage;

public class SubmitOrderTest extends BaseTest {
	
	String productName = "ADIDAS ORIGINAL";
	@Test
	public void submitOrder() throws IOException {
		// TODO Auto-generated method stub
		String countryName = "india";
		String expectedMessage = "THANKYOU FOR THE ORDER.";
		
		//As we have to everytime launchapplicaton for every test,so its common
		//LandingPage landingPage = launchApplication();
		//In testng there is anotation as before method: whenever it try to execute any method then it would check first is there any
		//anotation called before method, so it would run first (in its own class and also in inheritant class)
		//As we remove declared line would give error,as object created is local to this method, so need to create at top of base class as public
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
		//MyOrderPage orderPage = successPage.moveToOrderPage();
		
		//orderPage.compareOrder(orderIdText);
		//orderPage.toastMessage();	
	}

	@Test (dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("jitendra@gmail.com", "Test@123");
		MyOrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyingOrderDisplay(productName));
		
		
	}
}
