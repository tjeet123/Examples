package practiseProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		//First need to cast driver by ((TakesScreenshot)driver)
		//After that screeshot is captured in file format to src object
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//It would save in d file 
		FileUtils.copyFile(src, new File("D://screenshot.png"));
		
	}

}
