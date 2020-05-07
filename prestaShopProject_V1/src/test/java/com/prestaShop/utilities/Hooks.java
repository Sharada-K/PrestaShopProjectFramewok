package com.prestaShop.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	private static WebDriver driver;
	static Scenario allScenarios;

	@Before("@ExecuteBeforeFeature")
	public void setUp(Scenario scenario){
		allScenarios = scenario;
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	} 

	@Before("@FunctionalTesting")
	public void beginEachScenarios(Scenario scenario)
	{
		allScenarios = scenario;
	}

	@After("@FunctionalTesting")
	public void endEachScenario()
	{
		if(allScenarios.isFailed())		
		{
			allScenarios.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
	}
	@After("@ExecuteAfterFeature")
	public void tearDown(){
		if(allScenarios.isFailed())		
		{
			allScenarios.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}
		driver.close();
		driver.quit();

	}

	public static WebDriver getDriver()
	{
		return driver;
	}
}