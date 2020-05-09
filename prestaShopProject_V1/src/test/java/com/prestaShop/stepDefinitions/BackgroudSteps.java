package com.prestaShop.stepDefinitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.prestaShop.utilities.ReadConfig;
import com.prestaShop.utilities.chooseYourBrowser;

import cucumber.api.java.en.*;

public class BackgroudSteps {

	WebDriver driver;
	Properties property;
	String path = "C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Configuration\\browser-config.properties";
	
	@Given("^Launch any browser$")
	public void launch_any_browser() {
		driver = chooseYourBrowser.getBrowser();
	}

	@Given("^Open URL$")
	public void open_URL()  {
		property = ReadConfig.ReadConfiguration(path);
		driver.get(property.getProperty("URL"));
	}
}
