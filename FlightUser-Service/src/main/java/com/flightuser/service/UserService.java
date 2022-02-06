package com.flightuser.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flightuser.dto.FlightResponseDTO;
import com.flightuser.dto.SearchFlightDTO;
import com.flightuser.dto.SearchFlightResultDTO;
import com.flightuser.shared.UserDTO;

@Service
public interface UserService {
	
	FlightResponseDTO toBookFlight(UserDTO userDTO,int flightId);

	List<SearchFlightResultDTO> searchFlight(SearchFlightDTO searchFlightDTO) throws URISyntaxException;

	FlightResponseDTO getFlightDetails(String pnr);

	void deleteFlightDetails(String pnr);

	List<FlightResponseDTO> getFlightBookingHistory(String emailId);


}
