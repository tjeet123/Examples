package practiseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Select any checkbox
		driver.findElement(By.cssSelector("#checkBoxOption2")).click();
		
		//2. Grab the label of the selected checkbox
		String checkbox = driver.findElement(By.xpath("//label[@for='benz']")).getText();

		//3. Select an option in dropdown
		WebElement drpdownClick = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select dropdown = new Select(drpdownClick);
		dropdown.selectByVisibleText(checkbox);
		
		//4. Enter the step 2 grabbed label text in Editbox
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(checkbox);
		
		//5. Click Alert and then verify if text grabbed from step 2 is present in the pop-up  message
		driver.findElement(By.cssSelector("#alertbtn")).click();
		
		String actualText = driver.switchTo().alert().getText();
		System.out.println(actualText);
		Assert.assertEquals(actualText, "Hello Option2, share this practice page and share your knowledge");
		
		driver.switchTo().alert().accept();
		
	}

	/* or can be also done as below
	 public static void main(String[] args) {
// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");

        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		Select s=new Select(dropdown);
		s.selectByVisibleText(opt);
		driver.findElement(By.name("enter-name")).sendKeys(opt);
		driver.findElement(By.id("alertbtn")).click();
		String text=  driver.switchTo().alert().getText();
		if(text.contains(opt))
		{System.out.println("Alert message success");}
		else
		System.out.println("Something wrong with execution");

}//  System.out.println( driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());   
}	 */
}
