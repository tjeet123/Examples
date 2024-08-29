package practise.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement addCountry;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement placeOrderBtn;
	
	By listGroup = By.cssSelector(".list-group");
	
	public void suggestiveDropdown(String country)
	{
	//Suggestive box with different method
	Actions a = new Actions(driver);
	a.sendKeys(addCountry, country).build().perform();
	waitForElementToAppear(listGroup);
	selectCountry.click();
	
	//or -Suggestive dropdown
//	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("Ind");
//	
//	w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".list-group")));
//	//get suggestion
//	List<WebElement> country = driver.findElements(By.cssSelector(".list-group span"));
//	
//	for(int i=0;i<country.size();i++)
//	{
//		String result = country.get(i).getText().trim();
//
//		if(result.equals("India"))
//		{
//			country.get(i).click();
//			break;
//		}
//			
	}
	
	public SuccessPage placeOrder()
	{
		placeOrderBtn.click();
		SuccessPage successPage = new SuccessPage(driver);
		return successPage;
	
	}
}
