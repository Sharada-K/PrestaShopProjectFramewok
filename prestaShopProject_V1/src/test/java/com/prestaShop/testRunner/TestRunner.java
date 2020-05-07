package com.prestaShop.testRunner;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "./features",
		glue = {"com.prestaShop.stepDefinitions"},
				plugin = {"pretty:STDOUT","html:C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Reports\\cucumber-pretty",
						"json:C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Reports\\cucumber-json\\cucumber.json",
						"com.cucumber.listener.ExtentCucumber<Formatter>:C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Reports\\cucumber-extent\\report.html"},
		monochrome=true)

public class TestRunner extends AbstractTestNGCucumberTests{	

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception
	{
		System.out.println("Running scenarios");
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@Test(dataProvider="features")
	public void feature(CucumberFeatureWrapper cucumberFeature)
	{
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	@DataProvider
	public Object[][] features()
	{
		return testNGCucumberRunner.provideFeatures();
	}
	
	@AfterClass
	public void tearDownClass() throws Exception
	{
		Reporter.loadXMLConfig(new File("C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\extent-config.xml"));
		
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("64-Bit", "Windows-10");
		
		testNGCucumberRunner.finish();
	}
}
