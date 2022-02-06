package com.flightadmin.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequestFlightDetailsDTO {
	
	private int flightNo;
	private String flightName;
	private String airline;
	private String fromPlace;
	private String toPlace;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date endDate;
	private String boardingTime;
	private String departureTime;
	private List<String> scheduledDays;
	private String instrument;
	private int noOfBusinessClassSeats;
	private int noOfNonBusinessClassSeats;
	private int cost;
	
	
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getFromPlace() {
		return fromPlace;
	}
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	public String getToPlace() {
		return toPlace;
	}
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
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
	
	public String getBoardingTime() {
		return boardingTime;
	}
	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public List<String> getScheduledDays() {
		return scheduledDays;
	}
	public void setScheduledDays(List<String> scheduledDays) {
		this.scheduledDays = scheduledDays;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public int getNoOfBusinessClassSeats() {
		return noOfBusinessClassSeats;
	}
	public void setNoOfBusinessClassSeats(int noOfBusinessClassSeats) {
		this.noOfBusinessClassSeats = noOfBusinessClassSeats;
	}
	public int getNoOfNonBusinessClassSeats() {
		return noOfNonBusinessClassSeats;
	}
	public void setNoOfNonBusinessClassSeats(int noOfNonBusinessClassSeats) {
		this.noOfNonBusinessClassSeats = noOfNonBusinessClassSeats;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	
	
	

}
