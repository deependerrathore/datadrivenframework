package com.deepak.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.deepak.utilities.ExcelReader;
import com.deepak.utilities.ExtentManager;
import com.deepak.utilities.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {
	/*
	 * WebDriver
	 * Properties
	 * Logs
	 * Excel
	 * Extent
	 * Mail
	 * DB
	 * Extent Report and ReportNG
	 */
	
	public static WebDriver driver = null;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excels\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	@BeforeSuite
	public void setUp() {
		
		PropertyConfigurator.configure("C:\\Dev&Test\\testing\\selenium_framework\\DataDrivenFramework\\src\\test\\resources\\properties\\log4j.properties");

		
		if (driver == null) {
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				config.load(fis);
				log.debug("config file loaded!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded!");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/*
		 * Configuring the driver for different browser
		 */
		if (config.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.debug("Firefox Launched!");

		}else if(config.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Chrome Launched!");

		}else if(config.getProperty("browser").equals("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.debug("IE Launched!");

		}
		
		/*
		 * launching the URL
		 */
		driver.get(config.getProperty("testsiteurl"));
		log.debug("Navigated to" + config.getProperty("testsiteurl"));

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		
		wait = new WebDriverWait(driver, 5);
		
		
		
	}
	
	public void click(String locator) {
		if (locator.endsWith("_CSS")) {			
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_name")) {
			driver.findElement(By.name(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_CLASS")) {
			driver.findElement(By.className(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_LINKTEXT")) {
			driver.findElement(By.linkText(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_PARTIALLINKTEXT")) {
			driver.findElement(By.partialLinkText(OR.getProperty(locator))).click();
		}
		test.log(LogStatus.INFO, "Clicking on: "+locator);
	}
	
	public void type(String locator,String value) {
		if (locator.endsWith("_CSS")) {			
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_name")) {
			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_CLASS")) {
			driver.findElement(By.className(OR.getProperty(locator))).sendKeys(value);
		}
		test.log(LogStatus.INFO, "Typing in " + locator + " entered value is " +value);
	}
	
	static WebElement dropdown;
	public void select(String locator,String value) {
		if (locator.endsWith("_CSS")) {			
			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}else if (locator.endsWith("_XPATH")) {
			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		}else if (locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(OR.getProperty(locator)));
		}else if(locator.endsWith("_name")) {
			dropdown = driver.findElement(By.name(OR.getProperty(locator)));
		}else if(locator.endsWith("_CLASS")) {
			dropdown = driver.findElement(By.className(OR.getProperty(locator)));
		}
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		
		test.log(LogStatus.INFO, "Selecting from dropdown " + locator + " selected value is " +value);
	}
	public boolean isElementPresent(By by) {
			try {
				driver.findElement(by);
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}
	}
	
	public static void verifyEquals(String expected,String actual) throws IOException {
		try {
			Assert.assertEquals(actual, expected);
		}catch(Throwable t) {
			
			TestUtil.captureScreenshot();
			
			//ReportNG
			Reporter.log("<br>" + "Verification failed: " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" width=200 height=200/><a/>");		
			Reporter.log("<br>");
			Reporter.log("<br>");

			//Extent Report
			test.log(LogStatus.FAIL, "Verification failed with exception " + t.getMessage());		
			test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenshotName));
			
		}
	}
	
	@AfterSuite
	public void tearDown() {
		
		if (driver!=null) {			
			driver.quit();
		}
		log.debug("Test execution completed");
	}
}
