package com.prestshop.utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserUtils {

	public static WebDriver driver;
	private static Properties property;
	private static String path = "C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\PrestaShopProject_V3\\Configuration\\browser-config.properties";
	private static Logger logger = Log4jUtilities.logger;
	
	//This method will return the driver
	public static WebDriver getBrowser()
	{
		property = ReadConfig.ReadConfiguration(path);
		String browser = property.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome browser initiated");
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./Driver/internetexplorer.exe");
			driver = new InternetExplorerDriver();
			logger.info("IE browser initiated");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("Firefox browser initiated");
		}
		driver.get(property.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	//This method will quit the driver
	public static void closeBrowser()
	{
		driver.quit();
	}

}
