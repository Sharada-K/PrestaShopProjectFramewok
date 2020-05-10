package com.prestashop.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.prestashop.pageObjects.SignInPage;
import com.prestshop.utilities.Log4jUtilities;
import com.prestshop.utilities.ReadConfig;
import com.prestshop.utilities.BrowserUtils;

import cucumber.api.java.en.*;

public class TC_002_Login {

	private static Properties property;
	private static String path = "C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Configuration\\signin-config.properties";
	private WebDriver driver = BrowserUtils.driver;
	private SignInPage signInPage = new SignInPage(driver);
	private Logger logger = Log4jUtilities.logger;

	@Given("^I have account in prestashop$")
	public void i_have_account_in_prestashop() {
		logger.info("User have account in presta");
		property = ReadConfig.ReadConfiguration(path);
	}

	@Then("^I click on Signin link$")
	public void i_click_on_Signin_link() throws InterruptedException {
		signInPage.clickSignIn();
		logger.info("User clicked on login link");
	}

	@Then("^I enter email address in the email address field$")
	public void i_enter_email_address_in_the_email_address_field()  {
		signInPage.setLoginEmail(property.getProperty("loginEmail"));
		logger.info("User entered email address");
	}

	@Then("^I enter password in the password field$")
	public void i_enter_password_in_the_password_field()  {
		signInPage.setLoginPassword(property.getProperty("loginPassword"));
		logger.info("User entered password");
	}

	@Then("^I click on signin button$")
	public void i_click_on_signin_button()  {
		signInPage.clickLoginButton();
		logger.info("User clicked on signin button");
	}

	@Then("^validate that logged in successfully with the above credentials$")
	public void validate_that_logged_in_successfully_with_the_above_credentials() throws IOException  {
		String expectedName = property.getProperty("fname") +" "+ property.getProperty("lname");
		signInPage.validateSignIn(expectedName, "TC_002_Login");
	}

}




