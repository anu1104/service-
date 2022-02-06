package com.flightadmin.dto;

public class ErrorResponseDTO {
	
	private String message;
    private Long errorReportingTime;
    private Integer statusCode;
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getErrorReportingTime() {
		return errorReportingTime;
	}
	public void setErrorReportingTime(Long errorReportingTime) {
		this.errorReportingTime = errorReportingTime;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
