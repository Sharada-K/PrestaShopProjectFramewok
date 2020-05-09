package com.prestashop.stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import com.prestashop.pageObjects.ItemSearchPage;
import com.prestshop.utilities.ReadConfig;
import com.prestshop.utilities.chooseYourBrowser;
import cucumber.api.java.en.*;

public class TC_003_AddTo_Cart {

	private static Properties property;
	private static String path = "C:\\Users\\Admin\\eclipse-workspace\\PrestaShopProject_V3\\Configuration\\product1-config.properties";
	private WebDriver driver = chooseYourBrowser.driver;
	private ItemSearchPage itemSearchPage = new ItemSearchPage(driver);
	
	@Given("^I am on the locate page$")
	public void i_am_on_the_locate_page()  {
		property = ReadConfig.ReadConfiguration(path);
	}

	@When("^I search for poster item$")
	public void i_search_for_poster_item() throws InterruptedException  {
		itemSearchPage.searchProduct(property.getProperty("product"));
	}
	
	@When("^I click search button$")
	public void i_click_search_button()
	{
		itemSearchPage.clickSearchButton();
	}

	@When("^I click on third product$")
	public void i_click_on_third_product() {
		itemSearchPage.clickThirdProduct();
	}

	@When("^I change the dimension to second option$")
	public void i_change_the_dimension_to_second_option()  {
		itemSearchPage.selectDimension();
	}

	@When("^I change the quantity to (\\d+)$")
	public void i_change_the_quantity_to(int arg1)  {
		itemSearchPage.enterQuantity(property.getProperty("quantity"));
	}

	@When("^I click on add to cart button$")
	public void i_click_on_add_to_cart_button()  {
		itemSearchPage.clickAddToCartButton();
	}

	@Then("^I validate that item added to the cart successfully$")
	public void i_validate_that_item_added_to_the_cart_successfully() throws InterruptedException, IOException {
		itemSearchPage.itemAddedSuccessfully(property.getProperty("label"),"TC_003_AddTo_Cart");
	}

}
