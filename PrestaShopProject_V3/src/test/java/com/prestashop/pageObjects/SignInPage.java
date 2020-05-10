package com.prestashop.pageObjects;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prestshop.utilities.Log4jUtilities;
import com.prestshop.utilities.ScreenshotUtils;
import com.prestshop.utilities.WebDriverWaitUtils;

public class SignInPage {

	private WebDriver driver;
	public SignInPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	WebElement signinLink;

	@FindBy(xpath="//div[@class='no-account']/a")
	WebElement createAccountLink;

	@FindBy(xpath="//input[@name='firstname']")
	WebElement fname;

	@FindBy(xpath="//input[@name='lastname']")
	WebElement lname;

	@FindBy(xpath="//input[@name='email']")
	WebElement email;

	@FindBy(xpath="//input[@name='password']")
	WebElement password;

	@FindBy(xpath="//input[@name='birthday']")
	WebElement birthday;

	@FindBy(xpath="//input[@name='psgdpr']")
	WebElement termsAndConditions;

	@FindBy(xpath="//button[@data-link-action='save-customer']")
	WebElement saveButton;

	@FindBy(xpath="//a[@class='account']//span[@class='hidden-sm-down']")
	WebElement signedinName;
	
	@FindBy(xpath="//div//div[@class='form-group row ']//input[@name='email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement loginPassword;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement loginButton;

	WebDriverWaitUtils w = new WebDriverWaitUtils();
	ScreenshotUtils s = new ScreenshotUtils();
	Logger logger = Log4jUtilities.logger;
	
	public void clickSignIn() throws InterruptedException
	{
		
		Thread.sleep(15000);
		driver.switchTo().frame(0);
		w.wait(driver,2,signinLink);
		signinLink.click();
	}

	public void setFirstName(String name)
	{
		fname.sendKeys(name);
	}

	public void setLastName(String name)
	{
		lname.sendKeys(name);
	}

	public void setEmail()
	{		
		String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
		String emailID = "User"+userName+"@gmail.com";
		email.sendKeys(emailID);
	}

	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}

	public void setBirthday(String bday)
	{
		birthday.sendKeys(bday);
	}

	public void checkTermsAndConditionsCheckbox()
	{
		termsAndConditions.click();
	}

	public void clickSubmit()
	{
		saveButton.click();
	}

	public void clickCreateAccountLink()
	{
		createAccountLink.click();
	}
	
	public void setLoginEmail(String email)
	{
		loginEmail.sendKeys(email);
	}
	
	public void setLoginPassword(String pwd)
	{
		loginPassword.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	
	public void validateSignIn(String expectedName,String TCName) throws IOException
	{
		String actualName = signedinName.getText();
		if(!(actualName.equals(expectedName)))
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

