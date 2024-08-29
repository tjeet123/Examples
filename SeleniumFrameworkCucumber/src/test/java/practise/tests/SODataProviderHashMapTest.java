package practise.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.HashAlgorithm;
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

public class SODataProviderHashMapTest extends BaseTest {
	
	
	//Need to attach data to test, so how to attach
	//Just put attribute as data provider
	//To run this test will add one group 
	@Test (dataProvider = "getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException {
		// TODO Auto-generated method stub
		String countryName = "india";
		String expectedMessage = "THANKYOU FOR THE ORDER.";
		
		
		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"),input.get("password"));
		
		List<WebElement> product = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		
		CartPage cartPage = productCatalogue.moveToCartPage();

		Boolean match = cartPage.verifyProducts(input.get("productName"));
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
		//But there is problem, there are 3 parameter and u catch, so if there are 15 parameter then, 15 parameter need to write.Is there any better way to handle it?
		//Data provider also allows to return hash map. You can send hashmap inside this arrays
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "jitendra@gmail.com");
		map.put("password", "Test@123");
		map.put("productName", "ADIDAS ORIGINAL");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "jitendra+1@gmail.com");
		map1.put("password", "Test@123");
		map1.put("productName", "ZARA COAT 3");
				//Send map object, this hashmap is send, not to send parameter
		//To add the value u use put method now add get method to get the value in test class
		return new Object[][] {{map} , {map1}};
	}
}
