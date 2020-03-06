package com.bitm.SeleniumMaven.DTO;

public class FlightFinderDTO {

	private String passengers;
	private String departing;
	private String month;
	private String day;
	private String arriving;
	private String rmonth;
	private String rday;
	private String airline;
	
	public String getPassengers() {
		return passengers;
	}
	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}
	public String getDeparting() {
		return departing;
	}
	public void setDeparting(String departing) {
		this.departing = departing;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getArriving() {
		return arriving;
	}
	public void setArriving(String arriving) {
		this.arriving = arriving;
	}
	public String getRmonth() {
		return rmonth;
	}
	public void setRmonth(String rmonth) {
		this.rmonth = rmonth;
	}
	public String getRday() {
		return rday;
	}
	public void setRday(String rday) {
		this.rday = rday;
	}
	
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	@Override
	public String toString() {
		return "FlightFinderDTO [passengers=" + passengers + ", departing=" + departing + ", month=" + month + ", day="
				+ day + ", arriving=" + arriving + ", rmonth=" + rmonth + ", rday=" + rday + ", airline=" + airline
				+ "]";
	}
	
		
}
