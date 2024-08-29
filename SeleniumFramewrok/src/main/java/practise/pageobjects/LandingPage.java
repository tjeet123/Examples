package practise.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practise.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	
	//Create constructor, as here driver is not recongise
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		//Before you touch anything in this class, constructor will first execute
		//this refers to current class instance variable
		this.driver = driver;
		//It will trigger when you call this method
		PageFactory.initElements(driver, this);
		
	}
	//PageFactory
	//Reduce the syntax of creating your webelement
	//What this annotation does is, Sending locator into argument and value at run time it would constructed like driver.findelement...
	//How this annotation know abt driver: There is one method called initelements which you have to write first, which will take care
	//of constructing that using driver argument what u send in method
	@FindBy(css="#userEmail")
	WebElement userEmail;	
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(name="login")
	WebElement sumbitBtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	//Action methods
	public ProductCatalogue loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		sumbitBtn.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
