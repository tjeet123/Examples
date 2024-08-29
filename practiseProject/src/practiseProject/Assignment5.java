package practiseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		
		//Click on the nested frame link
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		
		//move to top frame
		//driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		//one can select frame by its name 
		driver.switchTo().frame("frame-top");
				
		//move to sub-frame 
		//driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@name='frameset-middle'] //frame[2]")));
		//one can select frame by its name 
		driver.switchTo().frame("frame-middle");
		
		//get the text from frame
		System.out.println(driver.findElement(By.xpath("//div[text()='MIDDLE']")).getText());
		
		//move to the webpage
		driver.switchTo().defaultContent();
	}

	/*//Code from assignment 5
	 public static void main(String[] args) {
// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("http://the-internet.herokuapp.com/");

driver.findElement(By.linkText("Nested Frames")).click();
driver.switchTo().frame("frame-top");
driver.switchTo().frame("frame-middle");
System.out.println(driver.findElement(By.id("content")).getText());

} */
}
