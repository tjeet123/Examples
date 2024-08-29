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

public class SODataProviderJsonFileTest extends BaseTest {
	
	
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
	public Object[][] getData() throws IOException
	{
		//Need to run above method with 2 different data sets
		//Create 2 dimension array, basically need to return this array
		//Object is parent data type of int, string, etc.
		//But there is problem, there are 3 parameter and u catch, so if there are 15 parameter then, 15 parameter need to write.Is there any better way to handle it?
		//Data provider also allows to return hash map. You can send hashmap inside this arrays
		//Manually 2 hashmap created instead now should automatically create by scanning json,
		//Need to write method which scan json and create hashmap
		//First will call this method (moved to parent class) so no need to create object
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\practise\\data\\PurchaseOrder.json");
		
		//List of hash map , have to retrive the item from list then data.get(0)...	
		return new Object[][] {{data.get(0)} , {data.get(1)}};
	}

}
