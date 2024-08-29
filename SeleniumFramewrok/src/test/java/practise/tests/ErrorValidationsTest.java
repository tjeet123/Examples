package practise.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import practise.TestComponents.BaseTest;
import practise.TestComponents.Retry;
import practise.pageobjects.CartPage;
import practise.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {
	
	//The test which seems to be failed and want to rerun. Then go there and say as retryAnalyzer=Retry.class
	@Test (groups = {"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void loginErrorValidation() throws IOException {
		
		landingPage.loginApplication("jitendra@gmail.com", "Tes123");
		Assert.assertEquals("Incorrect email password.", landingPage.getErrorMessage());
		
	}

	@Test
	public void productErrorValidation() throws IOException {
		// TODO Auto-generated method stub
		String productName = "ADIDAS ORIGINAL";

		ProductCatalogue productCatalogue = landingPage.loginApplication("jitendra+1@gmail.com", "Test@123");
		
		List<WebElement> product = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
		CartPage cartPage = productCatalogue.moveToCartPage();

		Boolean match = cartPage.verifyProducts("ADIDAS ORIGINAL1");
		
		Assert.assertFalse(match);
	}
}
