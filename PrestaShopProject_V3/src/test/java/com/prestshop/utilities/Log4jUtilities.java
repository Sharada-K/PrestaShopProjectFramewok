package com.prestshop.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jUtilities {
	
	public static Logger logger;	
	
	//This method will initialize the logger
	public static void setLogger()
	{
		logger = Logger.getLogger("PrestaShop");
		PropertyConfigurator.configure("Log4j2.properties");
	}
}
