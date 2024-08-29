package practise.stepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import practise.TestComponents.BaseTest;
import practise.pageobjects.CartPage;
import practise.pageobjects.CheckoutPage;
import practise.pageobjects.LandingPage;
import practise.pageobjects.ProductCatalogue;
import practise.pageobjects.SuccessPage;

public class StepDefinitionImplementation extends BaseTest{

	//We are declaring object at global level so we can access it in all(different) methods
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public SuccessPage successPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		//We are catching the landing page by creating its object as launch application method returns landing page
		landingPage = launchApplication();
	}
	
	//U cannot write parameter, put regular expression(.+) whatever it has character or digit
	//For regular expression u can represent it by starting string with ^ and end with $
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password)
	{
		productCatalogue = landingPage.loginApplication(username,password);
	}
	
	
	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName)
	{
		List<WebElement> product = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_and_submit_order(String productName)
	{
		cartPage = productCatalogue.moveToCartPage();

		Boolean match = cartPage.verifyProducts(productName);
		//Validation cannot go in page object files. It only has code to perform actions 
		Assert.assertTrue(match);
		checkoutPage = cartPage.moveToCheckoutPage();		
						
		checkoutPage.suggestiveDropdown("India");
		successPage = checkoutPage.placeOrder();
	}
	
	//Below also there is parameterization
	//There are dynamic value, only difference is dynamic value is sitting in string and not coming from example
	//We can't use regular expression for direct string provide in step itself, then user {string} 
	@Then("{string} message is displayed on confirmationPage")
	public void message_displayed_confirmationPage(String string)
	{
		String confirmMessage = successPage.verifyMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("^verify the error message \"([^\"]*)\"$")
	public void verify_error_message(String errorMsg)
	{
		Assert.assertEquals(errorMsg, landingPage.getErrorMessage());
		driver.close();
	}
	
	//Just like group in testng there is tagging in cucumber Ex: @ErrorValidation @Regression
	
}
