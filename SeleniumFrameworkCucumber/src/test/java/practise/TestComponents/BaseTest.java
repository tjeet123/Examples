package practise.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import practise.pageobjects.LandingPage;

public class BaseTest {

	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver intilizeDriver() throws IOException
	{
		
	//properties class can read the global properties and decide run time on which browser need to run test cases
		//file should have .properties as extension in resources package
		//if u write any file name with .properties extension, then using properties class in java u would be able to pass this file and extract all global
		//parameters values
	
		Properties prop = new Properties();
		//file should be sent as inputstream
		//Below path is too long, if you give project to someone they dont have your local path: so test will fail
		//till your local path you can dynamically generate the path: There is one method
		//user.dir: IF u give this piece of code, it will automatically get the project path: it will give project location path dynamically
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practise\\resources\\GlobalData.properties");
		prop.load(fis);
	
		
		//We can set global values from ur maven commands
		//How if we directly handle it form commands through cmd : mvn test -Dbrowser=firefox (-D stands for maven parameter)
		//Some how from code u should be in position to listen to this maven variable so that u can update code accordingly
		//If u have anything in commands then use first that otherwise use through ur globaldata properties file
		
		//To read browser value which is coming from maven System.getProperty will read system level property
		//We are sending browser property from our maven if this property exist if its not equal to null
		//As it is null go get property from globaldata properties file
		//Java turnary operator: 
		String browserName = System.getProperty("browser") !=null ? System.getProperty("browser") : prop.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
//			//Chormeoptions is added as getting error while using driver.close, so will use of this argument, error is not displayed
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--user-data-dir=/tmp/your_tmp_folder");
//			driver = new ChromeDriver(options);
			driver = new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			//edge
		}
		//its common code
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	//We have to make file path generic as it can be used by each class
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//Fileutiles: It will scan the json file and convert that into string variable
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
		//Convert string to hashmap: with existing dependecies its not possible
		//It can be done through new dependecies called Jackson Databind (Add dependency for mvn repository: Jackson Databind)
		ObjectMapper mapper = new ObjectMapper();
		//We are reading the value we have create object of class as mapper (readvalue: which can read the string and convert to hashmap) 
		//In read method there are 2 arguments: first argument is the string what want to coverted into Hashmap
		//Second argument u need to tell how u want to convert it
		//There are 2 arrays present in json with 2 indexes, go and create 2 hashmap, it will create a list and it will give us back
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {});
		//What this data stores: This data is list now with 2 argument: in 1 argument it has 1st hashmap and in 2nd argument it has 2nd hashmap
		//This is what we are going to get  {{map} , {map1}} in the list here it is returning data
		return data;
		
	}
	//In Every project after invoking browser need to land on landing page, so need to launch app 
	@BeforeMethod (alwaysRun = true)
	public LandingPage launchApplication() throws IOException
	{
		//As above method is declaring driver for us, so should be call here
		//It returns webdriver driver but webdriver is declared as public, so no need to declare it
		driver = intilizeDriver();
		//First need to land on initial page of project, so we can keep it generic
		//So remove initialization as it intialized at top as public
		landingPage = new LandingPage(driver); 
		landingPage.goTo();
		return landingPage;
	}
	//@AfterMethod (alwaysRun = true)
	public void tearDown()
	{
		driver.close();
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		//First need to cast driver
		TakesScreenshot ts = (TakesScreenshot)driver;
		//after taking screenshot how output shouldbe as File, so we can store in local system
		File src = ts.getScreenshotAs(OutputType.FILE);
		//testcase name is given as string so to know which method got fail 
		File file = new File(System.getProperty("user.dir")+"//screenshots//"+testCaseName+".png");
		//Screenshot is taken but file need to store in our local workspace and destination to store file is asked in form of file
		FileUtils.copyFile(src, file);
		return System.getProperty("user.dir")+"//screenshots//"+testCaseName+".png";
		
	}
}
