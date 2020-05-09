package com.prestashop.stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.prestashop.pageObjects.ItemDetails;
import com.prestashop.pageObjects.ItemSearchPage;
import com.prestshop.utilities.ReadConfig;
import com.prestshop.utilities.chooseYourBrowser;
import cucumber.api.java.en.*;

public class TC_004_AddToCartAndValidateProductDetails {

	private static Properties property;
	private static String path = "C:\\Users\\Admin\\eclipse-workspace\\PrestaShopProject_V3\\Configuration\\product2-config.properties";
	private WebDriver driver = chooseYourBrowser.driver;
	private ItemSearchPage itemSearchPage = new ItemSearchPage(driver);
	
	@Given("^I am on the item search page$")
	public void i_am_on_the_item_search_page()  {
		property = ReadConfig.ReadConfiguration(path);
	}

	@When("^I search for tshirt$")
	public void i_search_for_tshirt() throws InterruptedException  {
		itemSearchPage.searchProduct(property.getProperty("product"));
	}
	
	@When("^I click Search button$")
	public void i_click_Search_button()
	{
		itemSearchPage.clickSearchButton();
	}

	@When("^I click on the first product$")
	public void i_click_on_the_first_product() {
		itemSearchPage.clickFirstProduct();
	}

	@When("^I click on Add to cart$")
	public void i_click_on_Add_to_cart()  {
		itemSearchPage.clickAddToCartButton();
	}

	@When("^I click on proceed to check out button$")
	public void i_click_on_proceed_to_check_out_button() throws InterruptedException  {
		itemSearchPage.clickProceedToCheckOutButton();
	}

	@Then("^I validate the name and quantity of the item$")
	public void i_validate_the_name_and_quantity_of_the_item() throws IOException {
		ItemDetails itemDetails = new ItemDetails(driver);
		itemDetails.validateProductName(property.getProperty("name"),"TC_004_AddToCartAndValidateProductDetails");
		itemDetails.validateProductQuantity(property.getProperty("quantity"),"TC_004_AddToCartAndValidateProductDetails");
	}

	
}
