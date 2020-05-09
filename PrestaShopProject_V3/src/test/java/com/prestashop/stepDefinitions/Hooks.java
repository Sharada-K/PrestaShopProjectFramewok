package com.prestashop.stepDefinitions;

import com.prestshop.utilities.chooseYourBrowser;

import cucumber.api.java.*;

public class Hooks {

	@Before
	public void launchBrowser()
	{
		chooseYourBrowser.getBrowser();
	}
	
	@After
	public void closeBrowser()
	{
		chooseYourBrowser.closeBrowser();
	}
}
