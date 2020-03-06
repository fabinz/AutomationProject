package com.bitm.SeleniumMaven.DataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.bitm.SeleniumMaven.Utils.ExcelUtils;

public class FlightBookingDataProvider {
	
	
	@DataProvider(name="FBdata")
	public static Object [][] getFlightBookingData(){
		try {
			return new Object[][]{
					{
						ExcelUtils.getFlightBookingData()
					},
				};
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
