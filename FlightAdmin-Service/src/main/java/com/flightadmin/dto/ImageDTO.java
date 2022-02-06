package com.flightadmin.dto;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image_table")
public class ImageDTO {
	
	
	public ImageDTO() {
			super();
		}

		public ImageDTO(String name, String type, byte[] picByte,String flightName) {
			this.name = name;
			this.type = type;
			this.picByte = picByte;
			this.flightName=flightName;
		}

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		@Column(name = "name")
		private String name;
		
		@Column(name = "flight_name")
		private String flightName;

		@Column(name = "type")
		private String type;

	    //image bytes can have large lengths so we specify a value
	    //which is more than the default length for picByte column
		@Column(name = "picByte", length = 1000)
		private byte[] picByte;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public byte[] getPicByte() {
			return picByte;
		}

		public void setPicByte(byte[] picByte) {
			this.picByte = picByte;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFlightName() {
			return flightName;
		}

		public void setFlightName(String flightName) {
			this.flightName = flightName;
		}

		@Override
		public String toString() {
			return "ImageDTO [id=" + id + ", name=" + name + ", flightName=" + flightName + ", type=" + type
					+ ", picByte=" + Arrays.toString(picByte) + "]";
		}
		
		
	}


