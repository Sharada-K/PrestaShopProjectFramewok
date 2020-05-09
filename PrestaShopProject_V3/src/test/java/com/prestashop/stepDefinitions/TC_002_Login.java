package com.prestashop.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

import com.prestashop.pageObjects.SignInPage;
import com.prestshop.utilities.ReadConfig;
import com.prestshop.utilities.chooseYourBrowser;

import cucumber.api.java.en.*;

public class TC_002_Login {

	chooseYourBrowser BR;
	private static Properties property;
	private static String path = "C:\\Users\\Admin\\git\\PrestaShopProjectFramewok\\prestaShopProject_V1\\Configuration\\signin-config.properties";

	public TC_002_Login(chooseYourBrowser BR)
	{
		this.BR = BR;
	}

	private SignInPage signInPage = new SignInPage(BR.driver);

	@Given("^I have account in prestashop$")
	public void i_have_account_in_prestashop() {
		property = ReadConfig.ReadConfiguration(path);
	}

	@Then("^I click on Signin link$")
	public void i_click_on_Signin_link() throws InterruptedException {
		signInPage.clickSignIn();
	}

	@Then("^I enter email address in the email address field$")
	public void i_enter_email_address_in_the_email_address_field()  {
		signInPage.setLoginEmail(property.getProperty("loginEmail"));
	}

	@Then("^I enter password in the password field$")
	public void i_enter_password_in_the_password_field()  {
		signInPage.setLoginPassword(property.getProperty("loginPassword"));
	}

	@Then("^I click on signin button$")
	public void i_click_on_signin_button()  {
		signInPage.clickLoginButton();
	}

	@Then("^validate that logged in successfully with the above credentials$")
	public void validate_that_logged_in_successfully_with_the_above_credentials() throws IOException  {
		String expectedName = property.getProperty("fname") +" "+ property.getProperty("lname");
		signInPage.validateSignIn(expectedName, "TC_002_Login");
	}

}




