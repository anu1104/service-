package com.flightuser.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Passenger_Details")
public class PassengerDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="gender")
	private String gender;
	@Column(name="age")
	private int age;
	@Column(name="Seat_No")
	private String seatNo;
	/*@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Flight_Id")
	private FlightRegistrationDTO flightRegistrationDTO;*/
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public FlightRegistrationDTO getFlightRegistrationDTO() {
		return flightRegistrationDTO;
	}
	public void setFlightRegistrationDTO(FlightRegistrationDTO flightRegistrationDTO) {
		this.flightRegistrationDTO = flightRegistrationDTO;
	}*/
	
	

}
