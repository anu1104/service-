package com.flightadmin.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight_details")
public class FlightDetailsDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="flight_no",unique=true)
	private int flightNo;
	@Column(name="flight_name")
	private String flightName;
	@Column(name="airline_name")
	private String airline;
	@Column(name="from_place")
	private String fromPlace;
	@Column(name="to_Place")
	private String toPlace;
	@Column(name="start_date")
	private String startDate;
	@Column(name="end_date")
	private String endDate;
	@Column(name="boarding_time")
	private String boardingTime;
	@Column(name="departure_time")
	private String departureTime;
	
	@Convert(converter = StringListConverter.class)
	private List<String> scheduledDays;
	@Column(name="instrument")
	private String instrument;
	@Column(name="no_of_businessclass_seats")
	private int noOfBusinessClassSeats;
	@Column(name="no_of_non_businessclass_seats")
	private int noOfNonBusinessClassSeats;
	@Column(name="cost")
	private int cost;
	
	/*public FlightDetailsDTO(int id, int flightNo, String airline, String fromPlace, String toPlace, Date startDate,
			Date endDate, String boardingTime, String departureTime, List<String> scheduledDays, String instrument,
			int noOfBusinessClassSeats, int noOfNonBusinessClassSeats, int cost) {
		super();
		this.id = id;
		this.flightNo = flightNo;
		this.airline = airline;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.startDate = startDate;
		this.endDate = endDate;
		this.boardingTime = boardingTime;
		this.departureTime = departureTime;
		this.scheduledDays = scheduledDays;
		this.instrument = instrument;
		this.noOfBusinessClassSeats = noOfBusinessClassSeats;
		this.noOfNonBusinessClassSeats = noOfNonBusinessClassSeats;
		this.cost = cost;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
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
