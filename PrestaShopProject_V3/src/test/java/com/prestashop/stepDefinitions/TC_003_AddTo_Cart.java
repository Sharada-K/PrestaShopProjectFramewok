package com.prestashop.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.prestashop.pageObjects.ItemSearchPage;
import com.prestshop.utilities.Log4jUtilities;
import com.prestshop.utilities.ReadConfig;
import com.prestshop.utilities.BrowserUtils;
import cucumber.api.java.en.*;

public class TC_003_AddTo_Cart {

	private static Properties property;
	private static String path = "C:\\Users\\Admin\\eclipse-workspace\\PrestaShopProject_V3\\Configuration\\product1-config.properties";
	private WebDriver driver = BrowserUtils.driver;
	private ItemSearchPage itemSearchPage = new ItemSearchPage(driver);
	private Logger logger = Log4jUtilities.logger;
	
	@Given("^I am on the locate page$")
	public void i_am_on_the_locate_page()  {
		logger.info("User on the item locate page");
		property = ReadConfig.ReadConfiguration(path);
	}

	@When("^I search for poster item$")
	public void i_search_for_poster_item() throws InterruptedException  {
		itemSearchPage.searchProduct(property.getProperty("product"));
		logger.info("User entered poster on the search textbox");
	}
	
	@When("^I click search button$")
	public void i_click_search_button()
	{
		itemSearchPage.clickSearchButton();
		logger.info("User clicked on search button");
	}

	@When("^I click on third product$")
	public void i_click_on_third_product() {
		itemSearchPage.clickThirdProduct();
		logger.info("User selected third product");
	}

	@When("^I change the dimension to second option$")
	public void i_change_the_dimension_to_second_option()  {
		itemSearchPage.selectDimension();
		logger.info("User selected 2nd option from the dimension drop down");
	}

	@When("^I change the quantity to (\\d+)$")
	public void i_change_the_quantity_to(int arg1)  {
		itemSearchPage.enterQuantity(property.getProperty("quantity"));
		logger.info("User entered quantity");
	}

	@When("^I click on add to cart button$")
	public void i_click_on_add_to_cart_button()  {
		itemSearchPage.clickAddToCartButton();
		logger.info("User clicked on add to cart button");
	}

	@Then("^I validate that item added to the cart successfully$")
	public void i_validate_that_item_added_to_the_cart_successfully() throws InterruptedException, IOException {
		itemSearchPage.itemAddedSuccessfully(property.getProperty("label"),"TC_003_AddTo_Cart");
	}

}
