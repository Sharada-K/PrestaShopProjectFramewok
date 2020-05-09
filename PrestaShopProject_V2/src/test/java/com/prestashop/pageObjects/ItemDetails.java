package com.prestashop.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ItemDetails {

	WebDriver driver;
	public ItemDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath="(//div[@class='product-line-info']/a)[1]")
	WebElement productName;
	
	@FindBy(xpath="(//div[@class='product-line-info'])[2]//span[2]")
	WebElement productDimension;
	
	@FindBy(xpath="//input[@class='js-cart-line-product-quantity form-control']")
	WebElement productQuantity;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement proceedToCheckOutButton;
	
	public String getActualProductName()
	{
		return productName.getText();
	}
	
	public String getActualProductDimension()
	{
		return productDimension.getText();
	}
	
	public String getActualProductQuantity()
	{
		return productQuantity.getAttribute("value");
	}
	
	public void clickProceedToCheckoutButton()
	{
		proceedToCheckOutButton.click();
		driver.switchTo().defaultContent();
	}
}
