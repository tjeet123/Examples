package practise.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;

public class SuccessPage extends AbstractComponent {

	WebDriver driver;
	public SuccessPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement actualMessage;
	
	@FindBy(css="label.ng-star-inserted")
	WebElement orderNo;
	
	@FindBy(css="label[routerlink*='myorders']")
	WebElement orderLink;
		
	public String verifyMessage()
	{
		
	//Verify successful message
	String confirmMessage = actualMessage.getText();
	return confirmMessage;
	}
	
	public String getOrderId()
	{
	//Get order id
	String orderid = orderNo.getText();
	String[] orderid1 = orderid.split(" ");
	String ord =orderid1[1]; 
	return ord;
	}
	
	public MyOrderPage moveToOrderPage()
	{
	//click on order history page
		orderLink.click();
		MyOrderPage orderPage = new MyOrderPage(driver);
		return orderPage;
	}
}
