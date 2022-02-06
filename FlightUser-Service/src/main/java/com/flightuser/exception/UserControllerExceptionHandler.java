package com.flightuser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flightuser.dto.ErrorResponseDTO;

public class UserControllerExceptionHandler {
	
	 @ExceptionHandler
	    public ResponseEntity<ErrorResponseDTO> handleUserNotFoundException(UserNotFoundException e)
	    {
		 ErrorResponseDTO errorResponseModel=new ErrorResponseDTO();
	        errorResponseModel.setMessage(e.getMessage());
	        errorResponseModel.setStatusCode(HttpStatus.NOT_FOUND.value());
	        errorResponseModel.setErrorReportingTime(System.currentTimeMillis());
	        return ResponseEntity.status(errorResponseModel.getStatusCode()).body(errorResponseModel);
	    }

}
