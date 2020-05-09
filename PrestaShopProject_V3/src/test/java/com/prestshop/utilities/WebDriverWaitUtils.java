package com.prestshop.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitUtils {
	WebDriverWait w;
	public void wait(WebDriver driver, int time, WebElement WE)
	{
		w = new WebDriverWait(driver,time);
		w.until(ExpectedConditions.visibilityOf(WE));
	}
}
