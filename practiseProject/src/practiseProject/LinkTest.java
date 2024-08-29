package practiseProject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int linksCount = allLinks.size();
		
		System.out.println("Total links count in site : "+linksCount);
		
		//Taking links of only footer (Scope getting limited)
		
		WebElement footerLinks = driver.findElement(By.id("gf-BIG"));
		List<WebElement> footerLinks1 = footerLinks.findElements(By.tagName("a"));
		int footerCount = footerLinks1.size();
		//All footer links in website, count displayed
		System.out.println("Footer Links count are: " +footerCount);
		for(int i=0;i<footerCount;i++)
		{
			System.out.println("Footers Links are " +footerLinks.findElements(By.tagName("a")).get(i).getText());
		}
		System.out.println("*********************************************************");
		//Limit the scope of getting only single coloumn of footer
		
		WebElement firstFooter = driver.findElement(By.xpath("//tbody/tr/td [1]/ul [1]"));
		List<WebElement> fFooterLinks = firstFooter.findElements(By.tagName("a"));
		int footerColCount = fFooterLinks.size();
		
		for(int i=1;i<footerColCount;i++)
		{
			String clickonLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			fFooterLinks.get(i).sendKeys(clickonLinkTab);
			Thread.sleep(5000);
		}
		//Open all the tabs
		Set<String> s = driver.getWindowHandles();
		Iterator<String> its = s.iterator();
		
		while(its.hasNext())
		{
			driver.switchTo().window(its.next());
			System.out.println("First column footer links are:" +driver.getTitle());
		}
		
		driver.quit();
	}
		
}
