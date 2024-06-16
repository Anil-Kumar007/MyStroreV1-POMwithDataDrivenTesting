package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;


import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	
	public String url = readConfig.getBaseUrl();
	public String browser = readConfig.getBrowserName();
	
	public String email = readConfig.getEmail();
	public String password = readConfig.getPassword();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setUp() {
		if(browser.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (browser.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		}else if(browser.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}else if(browser.equalsIgnoreCase("Safari")) {
			
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();

		}else {
			driver=null;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// for logging
		logger = LogManager.getLogger("hybridframework");// mention project names
		
		driver.get(url);
		logger.info("Browser open and landed to Website!!!");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		logger.info("Browser close!!!");
	}
	
	public void captureScreenShot(WebDriver driver, String testName) {
		TakesScreenshot screenshots = (TakesScreenshot) driver;
		
		File src = screenshots.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//Screenshots//"+ testName+".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Timeouts waitTimer(int timeInSeconds) {
		Timeouts timeout = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSeconds));
		return timeout;
	}
	
	public static String getPageTitle() {
		String currentPageTitle = driver.getTitle();
		return currentPageTitle;
	}
	
	public static void mouseClickOperation(WebElement singleClick) {
		Actions singleClickMouseAction = new Actions(driver);
		Actions singleClickPerform = singleClickMouseAction.moveToElement(singleClick).doubleClick();
		singleClickPerform.perform();
	}
	
}
