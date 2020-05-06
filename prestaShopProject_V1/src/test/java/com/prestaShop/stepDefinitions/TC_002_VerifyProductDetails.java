package com.prestaShop.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.prestaShop.pageObjects.ItemDetails;
import com.prestaShop.pageObjects.ItemSearchPage;
import com.prestaShop.utilities.Hooks;
import com.prestaShop.utilities.ReadConfig;

import cucumber.api.java.en.*;


public class TC_002_VerifyProductDetails {

	
	ItemDetails ID;
	ReadConfig RC;
	private WebDriver driver;
	public TC_002_VerifyProductDetails()
	{
		this.driver = Hooks.getDriver();
	}
	
	@Given("^An item on the locate page$")
	public void an_item_on_the_locate_page() {
		//An item loaded in the locate page
	}

	@When("^I click on proceed to check out button$")
	public void i_click_on_proceed_to_check_out_button() {
		
	}

	@Then("^I verify product details$")
	public void i_verify_product_details() {
		RC = new ReadConfig("./Configuration/product-config.properties");
		ID = new ItemDetails(driver);
		ID.clickProceedToCheckoutButton();
		driver.switchTo().frame(0);
		Assert.assertEquals(RC.getExpectedProductName(),ID.getActualProductName());
		Assert.assertEquals(RC.getExpectedProductDimension(), ID.getActualProductDimension());
		Assert.assertEquals(RC.getExpectedProductQuantity(), ID.getActualProductQuantity());
	}
}
