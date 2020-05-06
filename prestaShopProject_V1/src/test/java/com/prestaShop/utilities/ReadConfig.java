package com.prestaShop.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties property;
	public ReadConfig(String path)
	{
		File src = new File(path);
		try
		{
			FileInputStream fis = new FileInputStream(src);
			property = new Properties();
			property.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is:"+e.getMessage());
		}
	}
	
	public String getBaseURL()
	{
		return property.getProperty("URL");
	}

	public String getFirstName()
	{
		return property.getProperty("firstName");
	}
	
	public String getLastName()
	{
		return property.getProperty("lastName");
	}
	
	public String getPassword()
	{
		return property.getProperty("password");
	}
	
	public String getBirthday()
	{
		return property.getProperty("birthday");
	}
	public String getProduct()
	{
		return property.getProperty("product");
	}
	
	public String getProductQuantity()
	{
		return property.getProperty("quantity");
	}
	
	public String getAddItemLabel()
	{
		return property.getProperty("label");
	}
	
	public String getExpectedProductName()
	{
		return property.getProperty("ExpectedProductName");
	}
	
	public String getExpectedProductDimension()
	{
		return property.getProperty("ExpectedProductDimension");
	}
	
	public String getExpectedProductQuantity()
	{
		return property.getProperty("ExpectedProductQuantity");
	}
	
}
