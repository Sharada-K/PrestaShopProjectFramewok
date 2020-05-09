package com.prestashop.stepDefinitions;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.prestshop.utilities.ReadConfig;
import com.prestshop.utilities.chooseYourBrowser;
import cucumber.api.java.en.*;

public class BackGroundRun extends chooseYourBrowser{
	
	Properties property;
	String path = "C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Configuration\\browser-config.properties";

	@Given("^Launch any browser$")
	public void launch_any_browser() {
		chooseYourBrowser.getBrowser();
	}

	@Given("^Open URL$")
	public void open_URL() {
		property = ReadConfig.ReadConfiguration(path);
		driver.get(property.getProperty("URL"));
	}
}
