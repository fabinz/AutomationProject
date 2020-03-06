package com.bitm.SeleniumMaven.DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.bitm.SeleniumMaven.Utils.ExcelUtils;

public class FlightFinderDataProvider {
	
	@DataProvider(name="FFdata")
	public static Object [][] getFlightFinderData(){
		try {
			return new Object[][]{
					{
						ExcelUtils.getFlightFinderData()
					},
				};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
