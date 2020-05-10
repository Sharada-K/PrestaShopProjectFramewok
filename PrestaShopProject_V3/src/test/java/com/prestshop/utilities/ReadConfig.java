package com.prestshop.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	private static Properties property;
	
	//This methos will initialize the property
	public static Properties ReadConfiguration(String path)
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
		return property;
	}
}
