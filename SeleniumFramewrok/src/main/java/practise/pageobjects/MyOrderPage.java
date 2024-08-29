package practise.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;



public class MyOrderPage extends AbstractComponent{

	WebDriver driver;
	
	public MyOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(css=".ng-star-inserted th:first-child")
	List<WebElement> ordersList;
	
	@FindBy(css=".btn-danger")
	WebElement deleteBtn;
	
	@FindBy(css=".toast-message")
	WebElement successMessage;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderProductNames;
	
	public void compareOrder(String orderId)
	{
	//Get order id
		
			
			for(int i=0;i<ordersList.size();i++)
			{
				String orderNo = ordersList.get(i).getText();
				
				if(orderNo.equals(orderId))
				{
					deleteBtn.click();
					break;
				}
			}
	}
	
	public void toastMessage()
	{
		//Get successful message
		String deleteMessage = successMessage.getText();
		System.out.println(deleteMessage);
	}
	
	public Boolean VerifyingOrderDisplay(String productName)
	{
		Boolean match = orderProductNames.stream().anyMatch(orderProductName->orderProductName.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
}
