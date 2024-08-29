package practiseProject;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

		//If need to open any extention then above code can be used
		//options.addExtensions("path"); //In the path download extension file and give its path
		
//		// Chrome options support tutorial -- https://chromedriver.chromium.org/capabilities
//		//To set any proxy 
//		Proxy proxy = new Proxy();
//		proxy.setFtpProxy("ipaddress:4444");
//		options.setCapability("proxy", proxy);
		
		//Sometimes in site small pop-up is displayed at left side for allow location (blocking the pop-up)
		//If need to block pop-up then they would be blocked
		//options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		//Click on link that downloads the file,default it download at download directory and in below one can set where it should download
//		Map<String, Object> prefs = new HashMap<String, Object>();
//		prefs.put("download.default_directory", "/directory/path");
//		options.setExperimentalOption("prefs", prefs);
		
		
		System.setProperty("webdriver.chorme.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
