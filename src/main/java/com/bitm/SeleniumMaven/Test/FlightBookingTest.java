package com.bitm.SeleniumMaven.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.bitm.SeleniumMaven.DTO.Passengers;
import com.bitm.SeleniumMaven.DataProvider.FlightBookingDataProvider;
import com.bitm.SeleniumMaven.Utils.DriverManager;
import com.bitm.SeleniumMaven.Utils.UrlTextUtils;
import com.bitm.SeleniumMaven.Utils.XPathUtils;

public class FlightBookingTest {
	private WebDriver driver = null;

	@Test
	public void checkFlightBookingPageTitle() {
		driver = DriverManager.driver;

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(XPathUtils.FlightBooking.FNAME_SLOT)));
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.TEXT.FlightBooking_PAGE_TITLE);
		System.out.println("Flight Booking page verified");

	}

	@Test(dependsOnMethods = "checkFlightBookingPageTitle", dataProvider = "FBdata", dataProviderClass = FlightBookingDataProvider.class)
	public void FlightbookingTest (List<Passengers> FBdata)

	{
		for (Passengers fbooking : FBdata) {
			
			driver.findElement(By.xpath(XPathUtils.FlightBooking.FNAME_SLOT)).click();
			driver.findElement(By.xpath(XPathUtils.FlightBooking.FNAME_SLOT)).sendKeys(fbooking.getFirstName());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.LNAME_SLOT)).sendKeys(fbooking.getLastName());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.MEAL_SLOT)).sendKeys(fbooking.getMeal());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.CCARD_SLOT)).sendKeys(fbooking.getCard().getCardType());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.NUMBER_SLOT)).sendKeys(fbooking.getCard().getNumber());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.EDATE_SLOT)).sendKeys(fbooking.getCard().getExpirationMonth());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.EYEAR_SLOT)).sendKeys(fbooking.getCard().getExpirationYear());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.FRSTNAME_SLOT)).sendKeys(fbooking.getCard().getFirstName());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.MIDNAME_SLOT)).sendKeys(fbooking.getCard().getMiddleName());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.LASTNAME_SLOT)).sendKeys(fbooking.getCard().getLastName());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.TICKETLESS_BTN)).click();

			driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLADD_SLOT)).sendKeys(fbooking.getBillingAddress().getAddress());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLCITY_SLOT)).sendKeys(fbooking.getBillingAddress().getCity());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLSTATE_SLOT)).sendKeys(fbooking.getBillingAddress().getState());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLPOST_SLOT)).sendKeys(fbooking.getBillingAddress().getPostalCode());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLCOUNTRY_SLOT)).sendKeys(fbooking.getBillingAddress().getCountry());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.BILLING_BTN)).click();

			driver.findElement(By.xpath(XPathUtils.FlightBooking.DELADD_SLOT)).sendKeys(fbooking.getDeliveryAddress().getAddress());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.DELCITY_SLOT)).sendKeys(fbooking.getDeliveryAddress().getState());

			driver.findElement(By.xpath(XPathUtils.FlightBooking.DELSTATE_SLOT)).sendKeys(fbooking.getDeliveryAddress().getState());
			driver.findElement(By.xpath(XPathUtils.FlightBooking.DELPOST_SLOT)).sendKeys(fbooking.getDeliveryAddress().getPostalCode());
			driver.findElement(By.xpath(XPathUtils.FlightBooking.DELCOUNTRY_SLOT)).sendKeys(fbooking.getDeliveryAddress().getCountry());
			driver.findElement(By.xpath(XPathUtils.FlightBooking.SECUREPURCHASE_BTN)).click();
		}
	}

}
