package com.prestaShop.stepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.prestaShop.pageObjects.ItemSearchPage;
import com.prestaShop.pageObjects.SignInPage;
import com.prestaShop.utilities.Hooks;
import com.prestaShop.utilities.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;


public class TC_001_AddToCart {

	ItemSearchPage ISP;
	ReadConfig RC;
	private WebDriver driver;
	public TC_001_AddToCart()
	{
		this.driver = Hooks.getDriver();
	}

	SignInPage SIP;

	@Given("^I open URL$")
	public void open_URL_in_any_browser() throws InterruptedException {
		driver.get("http://demo.prestashop.com/#/en/front");
		Thread.sleep(5000);
	}

	//Create account in PrestaShop
	@Given("^I create account in PrestaShop$")
	public void create_account_in_PrestaShop() throws AWTException, InterruptedException {
		
		SIP = new SignInPage(driver);
		RC = new ReadConfig("./Configuration/baseClass-config.properties");

		driver.manage().deleteAllCookies();
		
		SIP.clickSignIn();
		SIP.clickCreateAccountLink();
		SIP.setFirstName(RC.getFirstName());
		SIP.setLastName(RC.getLastName());
		SIP.setEmail();
		SIP.setPassword(RC.getPassword());
		SIP.setBirthday(RC.getBirthday());
		SIP.checkTermsAndConditionsCheckbox();
		Thread.sleep(2000);
		SIP.clickSubmit();
		
		SIP.createCookie();

	}

	@When("^I search for poster item$")
	public void i_search_for_poster_item() throws InterruptedException {
		RC = new ReadConfig("./Configuration/product-config.properties");
		ISP = new ItemSearchPage(driver);

		ISP.searchProduct(RC.getProduct());
		Thread.sleep(3000);
		ISP.clickSearchButton();
	}

	@When("^I add third product to the cart from the search result$")
	public void i_add_third_product_to_the_cart_from_the_search_result() {

		ISP = new ItemSearchPage(driver);
		ISP.clickThirdProduct();
	}

	@When("^I change the dimension to second element$")
	public void i_change_the_dimension_to_second_element() {
		ISP = new ItemSearchPage(driver);
		ISP.selectDimension();
	}

	@When("^I change the quantity to (\\d+)$")
	public void i_change_the_quantity_to(int arg1) {
		RC = new ReadConfig("./Configuration/product-config.properties");
		ISP = new ItemSearchPage(driver);
		ISP.enterQuantity(RC.getProductQuantity());
	}

	@When("^I add item to shopping cart$")
	public void i_add_item_to_shopping_cart() {
		ISP = new ItemSearchPage(driver);
		ISP.clickAddToCartButton();
	}

	@Then("^I validate that item added to the cart successfully$")
	public void i_validate_that_item_added_to_the_cart_successfully() throws InterruptedException {
		ISP = new ItemSearchPage(driver);
		RC = new ReadConfig("./Configuration/product-config.properties");
		ISP.itemAddedSuccessfully(RC.getAddItemLabel());
	}


}
