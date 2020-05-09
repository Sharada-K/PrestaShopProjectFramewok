package com.prestaShop.stepDefinitions;

import java.util.Properties;
import org.junit.Assert;
import com.prestaShop.pageObjects.SignInPage;
import com.prestaShop.utilities.ReadConfig;
import com.prestaShop.utilities.chooseYourBrowser;

import cucumber.api.java.en.*;

public class TC_001_Signin {

	private static Properties property;
	private static String path = "C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Configuration\\signin-config.properties";
	private SignInPage signInPage = new SignInPage(chooseYourBrowser.getBrowser());
	
	@Given("^I have active email address$")
	public void i_have_active_email_address() {
		property = ReadConfig.ReadConfiguration(path);
	}

	@When("^I click on SignIn link$")
	public void i_click_on_SignIn_link() throws InterruptedException {
		signInPage.clickSignIn();
	}

	@When("^I click on create another account$")
	public void i_click_on_create_another_account()  {
		signInPage.clickCreateAccountLink();
	}

	@When("^I enter firstname and lastname$")
	public void i_enter_firstname_and_lastname() {
		signInPage.setFirstName(property.getProperty("fname"));
		signInPage.setLastName(property.getProperty("lname"));
	}

	@When("^I enter email address and new password$")
	public void i_enter_email_address_and_new_password() {
		signInPage.setEmail();
		signInPage.setPassword(property.getProperty("password"));
	}

	@When("^I enter birthday date$")
	public void i_enter_birthday_date() {
		signInPage.setBirthday(property.getProperty("birthday"));
	}

	@When("^I check the terms and conditions checkbox$")
	public void i_check_the_terms_and_conditions_checkbox()  {
		signInPage.checkTermsAndConditionsCheckbox();
	}

	@When("^I click on save button$")
	public void i_click_on_save_button() {
		signInPage.clickSubmit();
	}

	@Then("^I validate that signed in successfully with the above details$")
	public void i_validate_that_signed_in_successfully_with_the_above_details()  {
		String actualName = signInPage.actaulSigninName();
		String expectedName = property.getProperty("fname") + property.getProperty("lname");
		Assert.assertEquals(expectedName,actualName);
	}
}
