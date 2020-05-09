package com.prestashop.pageObjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.prestshop.utilities.ScreenshotUtils;
import com.prestshop.utilities.WebDriverWaitUtils;

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
	List<WebElement> product;
	
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
	
	@FindBy(xpath="//div[@class='cart-content-btn']/a")
	WebElement proceedToCheckOutButton;
	
	WebDriverWaitUtils w = new WebDriverWaitUtils();
	ScreenshotUtils s = new ScreenshotUtils();
	
	public void searchProduct(String product) throws InterruptedException
	{
		driver.switchTo().frame(0);
		w.wait(driver,10,productSearchText);
		productSearchText.sendKeys(product);
	}
	
	public void clickThirdProduct()
	{
		product.get(2).click();
	}
	
	public void clickFirstProduct()
	{
		product.get(0).click();
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
	
	public void itemAddedSuccessfully(String expectedText,String TCName) throws InterruptedException, IOException
	{
		driver.switchTo().activeElement();		
		w.wait(driver,10,itemAddedLabel);
		
		//Compare Actual text and Expected text
		String actualText = itemAddedLabel.getText();
		if(!(actualText.equals(expectedText)))
		{
			s.captureScreen(TCName);
			Assert.assertTrue(false);
		}		
	}
	
	public void clickProceedToCheckOutButton() throws InterruptedException
	{
		w.wait(driver,10,proceedToCheckOutButton);
		driver.switchTo().activeElement();
		proceedToCheckOutButton.click();
		driver.switchTo().defaultContent();
	}
}
