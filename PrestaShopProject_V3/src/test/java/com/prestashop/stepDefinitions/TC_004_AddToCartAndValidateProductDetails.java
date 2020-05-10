package com.prestashop.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.prestashop.pageObjects.ItemDetails;
import com.prestashop.pageObjects.ItemSearchPage;
import com.prestshop.utilities.Log4jUtilities;
import com.prestshop.utilities.ReadConfig;
import com.prestshop.utilities.BrowserUtils;
import cucumber.api.java.en.*;

public class TC_004_AddToCartAndValidateProductDetails {

	private static Properties property;
	private static String path = "C:\\Users\\Admin\\eclipse-workspace\\PrestaShopProject_V3\\Configuration\\product2-config.properties";
	private WebDriver driver = BrowserUtils.driver;
	private ItemSearchPage itemSearchPage = new ItemSearchPage(driver);
	private Logger logger = Log4jUtilities.logger;
	
	@Given("^I am on the item search page$")
	public void i_am_on_the_item_search_page()  {
		logger.info("User on the item locate page");
		property = ReadConfig.ReadConfiguration(path);
	}

	@When("^I search for tshirt$")
	public void i_search_for_tshirt() throws InterruptedException  {
		itemSearchPage.searchProduct(property.getProperty("product"));
		logger.info("User entered t-shirt on the search textbox");
	}
	
	@When("^I click Search button$")
	public void i_click_Search_button()
	{
		itemSearchPage.clickSearchButton();
		logger.info("User clicked on search button");
	}

	@When("^I click on the first product$")
	public void i_click_on_the_first_product() {
		itemSearchPage.clickFirstProduct();
		logger.info("User clicked on the first product");
	}

	@When("^I click on Add to cart$")
	public void i_click_on_Add_to_cart()  {
		itemSearchPage.clickAddToCartButton();
		logger.info("User clicked on add to cart button");
	}

	@When("^I click on proceed to check out button$")
	public void i_click_on_proceed_to_check_out_button() throws InterruptedException  {
		itemSearchPage.clickProceedToCheckOutButton();
		logger.info("User clicked on proceed to checkout button");
	}

	@Then("^I validate the name and quantity of the item$")
	public void i_validate_the_name_and_quantity_of_the_item() throws IOException {
		ItemDetails itemDetails = new ItemDetails(driver);
		itemDetails.validateProductName(property.getProperty("name"),"TC_004_AddToCartAndValidateProductDetails");
		itemDetails.validateProductQuantity(property.getProperty("quantity"),"TC_004_AddToCartAndValidateProductDetails");
	}

	
}
