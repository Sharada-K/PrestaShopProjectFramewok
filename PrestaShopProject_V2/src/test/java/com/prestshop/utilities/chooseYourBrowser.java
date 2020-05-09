package com.prestshop.utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class chooseYourBrowser {

	public static WebDriver driver;
	private static Properties property;
	private static String path = "C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Configuration\\browser-config.properties";
	
	public static WebDriver getBrowser()
	{
		property = ReadConfig.ReadConfiguration(path);
		String browser = property.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched");
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "./Driver/internetexplorer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("ie browser launched");
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("firefox browser launched");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
