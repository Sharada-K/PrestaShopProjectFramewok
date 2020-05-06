package com.prestaShop.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	private static WebDriver driver;
	@Before("@ExecuteBeforeFeature")
	public static void setUp(){
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	} 

	@After("@ExecuteAfterFeature")
	public static void tearDown(){
		driver.quit();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}