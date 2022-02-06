package com.flightuser.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightuser.service.UserService;
import com.flightuser.dto.FlightRequestDTO;
import com.flightuser.dto.FlightResponseDTO;
import com.flightuser.dto.SearchFlightDTO;
import com.flightuser.dto.SearchFlightResultDTO;
import com.flightuser.exception.UserNotFoundException;
import com.flightuser.shared.UserDTO;

@RestController
@CrossOrigin(origins="http//localhost:4200")
@RequestMapping("/api/v1.0/user/flight")
public class UserController {
	
	private static final Logger log =LoggerFactory.getLogger(UserController.class);
	
	private final UserService userService;
	private final ModelMapper modelMapper;
	
	public UserController(UserService userService, ModelMapper modelMapper) {
		super();
		this.userService = userService;
		this.modelMapper = modelMapper;
	}
	
	@GetMapping("/")
	public String getString() {
		return "anu";
	}
	
	@PostMapping("/booking/{flightid}")
	public ResponseEntity<FlightResponseDTO> flightRegistration(@RequestBody FlightRequestDTO
			flightRequestDTO, @PathVariable("flightid") int flightId){
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDTO userDTO =modelMapper.map(flightRequestDTO, UserDTO.class);
		
	FlightResponseDTO flight = userService.toBookFlight(userDTO,flightId);
	
	return  ResponseEntity.status(HttpStatus.CREATED).body(flight);
	}
	
	
	@PostMapping("/search")
	public ResponseEntity<List<SearchFlightResultDTO>> searchFlight (@RequestBody SearchFlightDTO 
			searchFlightDTO) throws URISyntaxException{
		
		System.out.println("date is"+searchFlightDTO.getDate());
		
		List<SearchFlightResultDTO> searchFlightResultDTO = userService.searchFlight(searchFlightDTO);
		
		System.out.println("dto is "+searchFlightResultDTO);
		
		return ResponseEntity.status(HttpStatus.OK).body(searchFlightResultDTO);
		
	}
	
    @GetMapping("/ticket/{pnr}")
	public ResponseEntity<FlightResponseDTO> getFlightDetails(@PathVariable("pnr") String pnr){
    	
    	FlightResponseDTO flightResponseDTO =userService.getFlightDetails(pnr);
    	
    	log.info("",flightResponseDTO);
    	if(flightResponseDTO == null) {
    		throw new UserNotFoundException("User with PNR Number--> "+pnr+" not found");
    	}
    	
    	return ResponseEntity.status(HttpStatus.OK).body(flightResponseDTO);
    }
    
    @DeleteMapping("/booking/cancel/{pnr}")
    public String deleteFlightDetails(@PathVariable("pnr") String pnr) {
    	
    	FlightResponseDTO flightResponseDTO =userService.getFlightDetails(pnr);
    	
    	if(flightResponseDTO == null) {
    		throw new UserNotFoundException("User with PNR Number--> "+pnr+" not found");
    		
    	}else {
    	
    	userService.deleteFlightDetails(pnr);
    	}
    	
    	return "Flight with PNR Number : "+ pnr+" is deleted";
    	
    }
    
    @GetMapping("/booking/history/{emailId}")
    public ResponseEntity<List<FlightResponseDTO>> getFlightBookingHistory(@PathVariable("emailId")
    String emailId){
    	
    	List<FlightResponseDTO> flightDetails = userService.getFlightBookingHistory(emailId);
    	
    	if(flightDetails.isEmpty() ||  flightDetails==null) {
    		
    		throw new UserNotFoundException("User with Email Id --> "+emailId+" not found");
    		
    	}
    	
    	return  ResponseEntity.status(HttpStatus.OK).body(flightDetails);
    }
    

}
