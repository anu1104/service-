package com.flightadmin.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserServiceResponseDTO {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;
	private int flightId;
	private String flightName;
	private String flightPrice;
	private ImageDTO imageDTO;
	public UserServiceResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserServiceResponseDTO(Date date, int flightId,String flightName, String flightPrice,ImageDTO imageDTO) {
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
