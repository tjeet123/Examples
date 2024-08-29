package practiseProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement email = driver.findElement(By.cssSelector("[name='email']"));
		email.sendKeys("test@gmail.com");
		
		//Captured email variable screenshot, it will capture and save in file
		File file = email.getScreenshotAs(OutputType.FILE);
		
		//Need physical file to open it with png or jpeg extension
		//common.io will convert file object to physical file, so need to add that jar
		// it will have source file and destination file
		FileUtils.copyFile(file, new File("sample.png"));
		
		
		//Get height and width of text boxes
		
		System.out.println(email.getRect().getDimension().getHeight());
		System.out.println(email.getRect().getDimension().getWidth());
		
	

	}

}
