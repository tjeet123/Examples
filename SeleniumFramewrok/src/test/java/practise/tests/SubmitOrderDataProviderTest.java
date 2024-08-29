package practise.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import practise.TestComponents.BaseTest;
import practise.pageobjects.CartPage;
import practise.pageobjects.CheckoutPage;
import practise.pageobjects.MyOrderPage;
import practise.pageobjects.ProductCatalogue;
import practise.pageobjects.SuccessPage;

public class SubmitOrderDataProviderTest extends BaseTest {
	
	
	//Need to attach data to test, so how to attach
	//Just put attribute as data provider
	//To run this test will add one group 
	@Test (dataProvider = "getData",groups= {"Purchase"})
	public void submitOrder(String email, String password, String productName) throws IOException {
		// TODO Auto-generated method stub
		String countryName = "india";
		String expectedMessage = "THANKYOU FOR THE ORDER.";
		
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(email,password);
		
		List<WebElement> product = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
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


	@DataProvider
	public Object[][] getData()
	{
		//Need to run above method with 2 different data sets
		//Create 2 dimension array, basically need to return this array
		//Object is parent data type of int, string, etc.
		
		return new Object[][] {{"jitendra@gmail.com", "Test@123","ADIDAS ORIGINAL"} , {"jitendra+1@gmail.com", "Test@123","ZARA COAT 3"}};
	}
}
