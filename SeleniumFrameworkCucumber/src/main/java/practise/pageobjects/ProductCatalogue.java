package practise.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> product;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;

	
	//PageFactory is exclusive for driver.findelement... and not for "By locator"
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector(".toast-success");
	
	//It will get product list, first we are waiting for product to appear on page then we are calling webelement are returning products
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return product;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod = getProductList().stream().filter(s->
		s.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		//Here we have taken prod webelement and not driver, so it scope would get limited to particular product
		//Its not driver so we cant use of pagefactory
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner);
		
		
	}

}
