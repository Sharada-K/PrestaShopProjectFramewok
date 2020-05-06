package com.prestaShop.testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
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
				plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html "},
		monochrome=true)
@Listeners({com.prestaShop.utilities.Listener.class})
public class TestRunner extends AbstractTestNGCucumberTests{	

	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception
	{
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
		testNGCucumberRunner.finish();
	}
}
