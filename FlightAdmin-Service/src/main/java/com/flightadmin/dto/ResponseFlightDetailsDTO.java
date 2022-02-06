package com.flightadmin.dto;

import java.util.Date;

public class ResponseFlightDetailsDTO {
	
	private Date startDate;
	private Date endDate;
	private String airline;
	private int cost;
	private boolean roundTrip;
	private boolean oneWayTrip;
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public boolean isRoundTrip() {
		return roundTrip;
	}
	public void setRoundTrip(boolean roundTrip) {
		this.roundTrip = roundTrip;
	}
	public boolean isOneWayTrip() {
		return oneWayTrip;
	}
	public void setOneWayTrip(boolean oneWayTrip) {
		this.oneWayTrip = oneWayTrip;
	}
	
	

}
