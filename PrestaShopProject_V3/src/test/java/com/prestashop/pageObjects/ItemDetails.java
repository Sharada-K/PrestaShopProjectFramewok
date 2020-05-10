package com.prestashop.pageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.prestshop.utilities.Log4jUtilities;
import com.prestshop.utilities.ScreenshotUtils;


public class ItemDetails {

	WebDriver driver;
	public ItemDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath="(//div[@class='product-line-info']/a)[1]")
	WebElement ProductName;
	
	@FindBy(xpath="//input[@class='js-cart-line-product-quantity form-control']")
	WebElement ProductQuantity;
	
	ScreenshotUtils s = new ScreenshotUtils();
	Logger logger = Log4jUtilities.logger;
	
	public void validateProductName(String expectedProductName,String TCName) throws IOException
	{
		driver.switchTo().frame(0);
		String actualProductName = ProductName.getText();
		if(!(actualProductName.equals(expectedProductName)))
		{
			logger.info("Testcase failed");
			s.captureScreen(TCName);
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("Testcase passed");
		}
	}
	
	public void validateProductQuantity(String expectedProductQuantity,String TCName) throws IOException
	{
		String actualProductQuantity = ProductQuantity.getAttribute("value");
		if(!(actualProductQuantity.equals(expectedProductQuantity)))
		{
			logger.info("Testcase failed");
			s.captureScreen(TCName);
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("Testcase passed");
		}
	}
}
