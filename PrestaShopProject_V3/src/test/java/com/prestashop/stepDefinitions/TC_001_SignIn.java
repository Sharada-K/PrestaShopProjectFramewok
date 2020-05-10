package com.prestashop.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.prestashop.pageObjects.SignInPage;
import com.prestshop.utilities.Log4jUtilities;
import com.prestshop.utilities.ReadConfig;
import com.prestshop.utilities.ScreenshotUtils;
import com.prestshop.utilities.BrowserUtils;
import cucumber.api.java.en.*;

public class TC_001_SignIn{

	private static Properties property;
	private static String path = "C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Configuration\\signin-config.properties";
	private WebDriver driver = BrowserUtils.driver;
	private SignInPage signInPage = new SignInPage(driver);
	ScreenshotUtils s = new ScreenshotUtils();
	private Logger logger = Log4jUtilities.logger;
	
	@Given("^I have active email address$")
	public void i_have_active_email_address() {
		logger.info("User have valid email address");
		property = ReadConfig.ReadConfiguration(path);
	}

	@When("^I click on SignIn link$")
	public void i_click_on_SignIn_link() throws InterruptedException  {
		signInPage.clickSignIn();
		logger.info("User clicked on login link");
	}

	@When("^I click on create another account$")
	public void i_click_on_create_another_account()  {
		signInPage.clickCreateAccountLink();
		logger.info("User clicked on create new account link");
	}

	@When("^I enter firstname and lastname$")
	public void i_enter_firstname_and_lastname() {
		signInPage.setFirstName(property.getProperty("fname"));
		signInPage.setLastName(property.getProperty("lname"));
		logger.info("User entered first name and last name");
	}

	@When("^I enter email address and new password$")
	public void i_enter_email_address_and_new_password() {
		signInPage.setEmail();
		logger.info("User entered email address");
		signInPage.setPassword(property.getProperty("password"));
		logger.info("User entered new password");
	}

	@When("^I enter birthday date$")
	public void i_enter_birthday_date() {
		signInPage.setBirthday(property.getProperty("birthday"));
		logger.info("User entered birthday in MM/DD/YYYY format");
	}

	@When("^I check the terms and conditions checkbox$")
	public void i_check_the_terms_and_conditions_checkbox() {
		signInPage.checkTermsAndConditionsCheckbox();
		logger.info("User clicked on terms and conditions checkbox");
	}

	@When("^I click on save button$")
	public void i_click_on_save_button() {
		signInPage.clickSubmit();
		logger.info("User clicked on save button");
	}

	@Then("^I validate that signed in successfully with the above details$")
	public void i_validate_that_signed_in_successfully_with_the_above_details() throws IOException  {
		String expectedName = property.getProperty("fname") +" "+ property.getProperty("lname");
		signInPage.validateSignIn(expectedName, "TC_001_Signin");
	}

	
}
