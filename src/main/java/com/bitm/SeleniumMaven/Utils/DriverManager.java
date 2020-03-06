package com.bitm.SeleniumMaven.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	static {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Desktop\\Selenium Files\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		
		}
	
	public static WebDriver driver = new FirefoxDriver();
	
	public void DriverExecutionTest()
	{
		System.out.println("Driver Executed");
	}
	
	

	 private DriverManager () {
	
}
}

