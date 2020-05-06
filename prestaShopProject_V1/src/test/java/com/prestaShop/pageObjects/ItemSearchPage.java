package com.prestaShop.pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ItemSearchPage {

	WebDriver driver;
	public ItemSearchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='ui-autocomplete-input']")
	WebElement productSearchText;
	
	@FindBy(xpath="//div[@class='thumbnail-container']")
	List<WebElement> poster;
	
	@FindBy(xpath="//div[@class='product-variants']/div/select")
	WebElement dimension;
	
	@FindBy(xpath="//input[@name='qty']")
	WebElement quantity;
	
	@FindBy(xpath="//button[@data-button-action='add-to-cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//form[@method='get']/button")
	WebElement searchButton;
	
	@FindBy(xpath="//h4[@id='myModalLabel']")
	WebElement itemAddedLabel;
	
	public void searchProduct(String product)
	{
		productSearchText.sendKeys(product);
	}
	
	public void clickThirdProduct()
	{
		poster.get(2).click();
	}
	
	public void selectDimension()
	{
		Select s = new Select(dimension);
		s.selectByIndex(1);
	}
	
	public void enterQuantity(String qty)
	{
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void clickAddToCartButton()
	{
		addToCart.click();
	}
	
	public void clickSearchButton()
	{
		searchButton.click();
	}
	
	public void itemAddedSuccessfully(String expectedText) throws InterruptedException
	{
		driver.switchTo().activeElement();		
		Thread.sleep(2000);
		
		//Compare Actual text and Expected text
		String actualText = itemAddedLabel.getText();
		System.out.println(actualText);
		Assert.assertEquals(actualText,expectedText);	
		
	}
}
