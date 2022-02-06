package com.flightuser.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="Flight_Registration_Details")
public class FlightRegistrationDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="PNR_Number",unique=true)
	private String pNR_Number;
	@Column(name="Flight_Id",nullable=true)
	private int flightId;
	@Column(name="Name",nullable=false)
	private String name;
	@Column(name="EmailID")
	private String emailID;
	@Column(name="journey_date")
	private Date journeyDate;
	@Column(name="source")
	private String source;
	@Column(name="destination")
	private String destination;
	@Column(name="gender")
	private String gender;
	@Column(name="age")
	private int age;
	@Column(name="seat_no")
	private String seatNo;
	@OneToMany(targetEntity=PassengerDTO.class,cascade =CascadeType.ALL,orphanRemoval = true,fetch=FetchType.EAGER)
	@JoinColumn(name="flight_id",referencedColumnName="id")
	private List<PassengerDTO> passengers;
	@Column(name="No_Of_Passenger")
	private int noOfPassenger;
	@Column(name="Opt_For_Meal")
	private String meal;
	@Column(name="type_of_Meal")
	private String typeOfMeal;
	
	
	
	
	public FlightRegistrationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	


	public FlightRegistrationDTO(int id, String pNR_Number, int flightId, String name, String emailID, Date journeyDate,
			String source, String destination,int age,String gender,String seatNo, List<PassengerDTO> passengers, int noOfPassenger, String meal,
			String typeOfMeal) {
		super();
		this.id = id;
		this.pNR_Number = pNR_Number;
		this.flightId = flightId;
		this.name = name;
		this.emailID = emailID;
		this.journeyDate = journeyDate;
		this.source = source;
		this.destination = destination;
		this.age = age;
		this.gender = gender;
		this.seatNo = seatNo;
		this.passengers = passengers;
		this.noOfPassenger = noOfPassenger;
		this.meal = meal;
		this.typeOfMeal = typeOfMeal;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPNR_Number() {
		return pNR_Number;
	}
	public void setPNR_Number(String pNR_Number) {
		this.pNR_Number = pNR_Number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getTypeOfMeal() {
		return typeOfMeal;
	}
	public void setTypeOfMeal(String typeOfMeal) {
		this.typeOfMeal = typeOfMeal;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public List<PassengerDTO> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<PassengerDTO> passengers) {
		this.passengers = passengers;
	}

    public String getpNR_Number() {
		return pNR_Number;
	}

    public void setpNR_Number(String pNR_Number) {
		this.pNR_Number = pNR_Number;
	}

    public Date getJourneyDate() {
		return journeyDate;
	}

    public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

    public String getSource() {
		return source;
	}

    public void setSource(String source) {
		this.source = source;
	}

    public String getDestination() {
		return destination;
	}

   public void setDestination(String destination) {
		this.destination = destination;
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
   
	
	}
