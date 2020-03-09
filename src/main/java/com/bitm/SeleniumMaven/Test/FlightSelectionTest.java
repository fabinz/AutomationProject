package com.bitm.SeleniumMaven.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.SeleniumMaven.Utils.DriverManager;
import com.bitm.SeleniumMaven.Utils.UrlTextUtils;
import com.bitm.SeleniumMaven.Utils.XPathUtils;

 public class FlightSelectionTest {
	
	private WebDriver driver = null; 
	
	@Test
	public void checkFlightSelectionPageTitle ()
	{
		driver = DriverManager.driver;
		
		WebDriverWait wait = new WebDriverWait (driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPathUtils.FlightSelection.DPT_BTN)));
		Assert.assertEquals(driver.getTitle(),UrlTextUtils.TEXT.FlightSelection_PAGE_TITLE );
		System.out.println("Flight Selection Page verified ");
		
	}
	
	@Test(dependsOnMethods = "checkFlightSelectionPageTitle")
	public void FlightSelectionTest ()
	{
		driver.findElement(By.xpath(XPathUtils.FlightSelection.DPT_BTN)).click();
		driver.findElement(By.xpath(XPathUtils.FlightSelection.RT_BTN)).click();
		driver.findElement(By.xpath(XPathUtils.FlightSelection.CNT_BTN)).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Flight Selected Successfully");
		
	}
	
	

}
