package com.flightuser.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SearchFlightResultDTO {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date date;
	private int flightId;
	private String flightName;
	private String flightPrice;
	private ImageDTO imageDTO;
	public SearchFlightResultDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SearchFlightResultDTO(Date date, int flightId,String flightName, String flightPrice,ImageDTO imageDTO) {
		super();
		this.date = date;
		this.flightId=flightId;
		this.flightName = flightName;
		this.flightPrice = flightPrice;
		this.imageDTO=imageDTO;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFlightPrice() {
		return flightPrice;
	}
	public void setFlightPrice(String flightPrice) {
		this.flightPrice = flightPrice;
	}
	public ImageDTO getImageDTO() {
		return imageDTO;
	}
	public void setImageDTO(ImageDTO imageDTO) {
		this.imageDTO = imageDTO;
	}
	
	

}
