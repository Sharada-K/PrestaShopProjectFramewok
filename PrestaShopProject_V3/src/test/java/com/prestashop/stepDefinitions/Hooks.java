package com.prestashop.stepDefinitions;

import org.apache.log4j.Logger;

import com.prestshop.utilities.Log4jUtilities;
import com.prestshop.utilities.BrowserUtils;

import cucumber.api.java.*;

public class Hooks {

	private Logger logger;
	@Before
	public void launchBrowser()
	{
		Log4jUtilities.setLogger();
		BrowserUtils.getBrowser();
		logger = Log4jUtilities.logger;
		logger.info("Logger initiated");
	}
	
	@After
	public void closeBrowser()
	{
		BrowserUtils.closeBrowser();
	}
}
