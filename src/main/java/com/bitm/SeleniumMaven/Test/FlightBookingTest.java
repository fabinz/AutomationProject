package com.bitm.SeleniumMaven.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.SeleniumMaven.DTO.FlightBookingDTO;
import com.bitm.SeleniumMaven.DTO.FlightFinderDTO;
import com.bitm.SeleniumMaven.DataProvider.FlightBookingDataProvider;
import com.bitm.SeleniumMaven.DataProvider.FlightFinderDataProvider;
import com.bitm.SeleniumMaven.Utils.DriverManager;
import com.bitm.SeleniumMaven.Utils.UrlTextUtils;
import com.bitm.SeleniumMaven.Utils.XPathUtils;

public class FlightBookingTest {
private WebDriver driver = null; 
	
	public void checkFlightBookingPageTitle ()
	{
		driver = DriverManager.driver;
		
		WebDriverWait wait = new WebDriverWait (driver, 40);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPathUtils.FlightBooking.FNAME_SLOT)));
		Assert.assertEquals(driver.getTitle(),UrlTextUtils.TEXT.FlightBooking_PAGE_TITLE );
		System.out.println("Flight Booking page verified ");
		
	}
	
	@Test(dependsOnMethods = "checkFlightBookingPageTitle" , dataProvider = "FBdata", dataProviderClass = FlightBookingDataProvider.class)
	public void FlightBookingTest (List<FlightBookingDTO> FBdata) {
		 for (FlightBookingDTO fbooking : FBdata)
		 {
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.FNAME_SLOT)).sendKeys(fbooking.getFname());
			
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.LNAME_SLOT)).sendKeys(fbooking.getLname());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.MEAL_SLOT)).sendKeys(fbooking.getMeal());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.CCARD_SLOT)).sendKeys(fbooking.getCcard());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.NUMBER_SLOT)).sendKeys(fbooking.getNumber());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.EDATE_SLOT)).sendKeys(fbooking. getEdate());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.EYEAR_SLOT)).sendKeys(fbooking.getEyear());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.FRSTNAME_SLOT)).sendKeys(fbooking.getFrstname());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.MIDNAME_SLOT)).sendKeys(fbooking.getMidname());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.LASTNAME_SLOT)).sendKeys(fbooking.getLastname());
			
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.TICKETLESS_BTN)).click();
	
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLADD_SLOT)).sendKeys(fbooking.getBilladd());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLCITY_SLOT)).sendKeys(fbooking.getCity());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLSTATE_SLOT)).sendKeys(fbooking.getState());
			 
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLPOST_SLOT)).sendKeys(fbooking.getPostalcode());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLCOUNTRY_SLOT)).sendKeys(fbooking.getCountry());
			
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLING_BTN)).click();

			 driver.findElement(By.xpath(XPathUtils.FlightBooking.DELADD_SLOT)).sendKeys(fbooking.getDeladd() );
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.DELCITY_SLOT)).sendKeys(fbooking.getDelcity());
				
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.DELSTATE_SLOT)).sendKeys(fbooking.getDelstate());
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.DELPOST_SLOT)).sendKeys(fbooking.getDelpost());
			 driver.findElement(By.xpath(XPathUtils.FlightBooking.DELCOUNTRY_SLOT)).sendKeys(fbooking.getDelcountry());
				
			 
				
			 
		 }
	}

	    
	
	
}
