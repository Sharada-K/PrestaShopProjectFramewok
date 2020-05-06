package com.prestaShop.pageObjects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	WebDriver driver;
	public SignInPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	WebElement signin;

	//	@FindBy(xpath="//div//div[@class='form-group row ']//input[@name='email']")
	//	WebElement email;
	//	
	//	@FindBy(xpath="//input[@name='password']")
	//	WebElement password;
	//	
	//	@FindBy(xpath="//button[@class='btn btn-primary']")
	//	WebElement signinButton;

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

	public void clickSignIn()
	{
		driver.switchTo().frame(0);
		signin.click();
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

	public void createCookie()
	{
		File file = new File("Cookies.data");							
		try		
		{	  
			// Delete old file if exists
			file.delete();		
			file.createNewFile();			
			FileWriter fileWrite = new FileWriter(file);							
			BufferedWriter Bwrite = new BufferedWriter(fileWrite);							
			// loop for getting the cookie information 		

			// loop for getting the cookie information 		
			for(Cookie ck : driver.manage().getCookies())							
			{			
				Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									
				Bwrite.newLine();             
			}			
			Bwrite.close();			
			fileWrite.close();	

		}
		catch(Exception ex)					
		{		
			ex.printStackTrace();			
		}		
	}		

}

