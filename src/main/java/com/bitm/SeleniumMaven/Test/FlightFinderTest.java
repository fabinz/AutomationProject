package com.bitm.SeleniumMaven.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bitm.SeleniumMaven.DTO.FlightFinderDTO;

import com.bitm.SeleniumMaven.DataProvider.FlightFinderDataProvider;

import com.bitm.SeleniumMaven.Utils.DriverManager;
import com.bitm.SeleniumMaven.Utils.UrlTextUtils;
import com.bitm.SeleniumMaven.Utils.XPathUtils;

public class FlightFinderTest {

	private WebDriver driver = null;

	@Test
	public void checkFlightFinderPageTitle() {
		driver = DriverManager.driver;

		WebDriverWait wait = new WebDriverWait(driver, 40);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(XPathUtils.FlightFinder.OneWay_BTN)));
		Assert.assertEquals(driver.getTitle(), UrlTextUtils.TEXT.FlightFinder_PAGE_TITLE);
		System.out.println("Find a flight page verified ");

	}

	@Test(dependsOnMethods = "checkFlightFinderPageTitle", dataProvider = "FFdata", dataProviderClass = FlightFinderDataProvider.class)
	public void FindAFlightTest(List<FlightFinderDTO> FFData) {
		for (FlightFinderDTO FFinder : FFData) {
			driver.findElement(By.xpath(XPathUtils.FlightFinder.OneWay_BTN)).click();

			driver.findElement(By.xpath(XPathUtils.FlightFinder.Passengers_BTN)).sendKeys(FFinder.getPassengers());
			// passengers.selectByVisibleText("2 ");

			driver.findElement(By.xpath(XPathUtils.FlightFinder.Depart_BTN)).sendKeys(FFinder.getDeparting());
			// depart.selectByVisibleText("San Francisco");

			driver.findElement(By.xpath(XPathUtils.FlightFinder.Month_BTN)).sendKeys(FFinder.getMonth());
			// month.selectByVisibleText("May");

			driver.findElement(By.xpath(XPathUtils.FlightFinder.Day_BTN)).sendKeys(FFinder.getDay());
			// day.selectByVisibleText("2");

			driver.findElement(By.xpath(XPathUtils.FlightFinder.Arrive_BTN)).sendKeys(FFinder.getArriving());
			// arrive.selectByVisibleText("Paris");

			driver.findElement(By.xpath(XPathUtils.FlightFinder.Return_BTN)).sendKeys(FFinder.getRmonth());
			// returns.selectByVisibleText("August");

			driver.findElement(By.xpath(XPathUtils.FlightFinder.RtDay_BTN)).sendKeys(FFinder.getRday());
			// rtDay.selectByVisibleText("21");

			driver.findElement(By.xpath(XPathUtils.FlightFinder.Service_BTN)).click();

			driver.findElement(By.xpath(XPathUtils.FlightFinder.Airline_BTN)).sendKeys(FFinder.getAirline());
			// airline.selectByVisibleText("Blue Skies Airlines"); s

			driver.findElement(By.xpath(XPathUtils.FlightFinder.Cont_BTN)).click();

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Flight Founded Successfully");

		}

	}
}
