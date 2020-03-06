package com.bitm.SeleniumMaven.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.bitm.SeleniumMaven.DTO.LoginDTO;
import com.bitm.SeleniumMaven.DataProvider.LoginDataProvider;
import com.bitm.SeleniumMaven.Utils.DriverManager;
import com.bitm.SeleniumMaven.Utils.UrlTextUtils;
import com.bitm.SeleniumMaven.Utils.XPathUtils;


@Listeners(com.bitm.SeleniumMaven.Utils.TestNGReporting.class)
public class LoginTest {
	private WebDriver driver = null ;
	
	@Test (priority=1)

	 public void checkloginpagetitle()
	{
	   driver = DriverManager.driver; 
	   driver.get(UrlTextUtils.URL.BASE_URL);
	   Assert.assertEquals(driver.getTitle(), UrlTextUtils.TEXT.LOGIN_PAGE_TITLE);
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   System.out.println("Login Page Title Verified");
	}
	
	@Test(dependsOnMethods = "checkloginpagetitle", dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void logintest(List<LoginDTO> logindata) {
		 for (LoginDTO login : logindata) {
			driver.findElement(By.xpath(XPathUtils.Login.USER_NAME)).sendKeys(login.getUsername());
			driver.findElement(By.xpath(XPathUtils.Login.PASS_WORD)).sendKeys(login.getPassword());
			driver.findElement(By.xpath(XPathUtils.Login.SIGN_IN_BTN)).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	}
}
