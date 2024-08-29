package practise.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import practise.pageobjects.CartPage;
import practise.pageobjects.MyOrderPage;

public class AbstractComponent {

	//Local object
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement miniCart;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy)
	{
		//(By.cssSelector(".mb-3")
		//Its not webelement but its "by locator"
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage moveToCartPage()
	{
		miniCart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public MyOrderPage goToOrderPage()
	{
		orderHeader.click();
		MyOrderPage orderPage = new MyOrderPage(driver);
		return orderPage;
	}


}
