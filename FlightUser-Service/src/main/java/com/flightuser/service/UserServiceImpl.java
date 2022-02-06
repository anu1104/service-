package com.flightuser.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.flightuser.dao.PassengerRepository;
import com.flightuser.dao.UserRepository;
import com.flightuser.dto.FlightRegistrationDTO;
import com.flightuser.dto.FlightResponseDTO;
import com.flightuser.dto.PassengerDTO;
import com.flightuser.dto.SearchFlightDTO;
import com.flightuser.dto.SearchFlightResultDTO;
import com.flightuser.shared.UserDTO;

@Service
public class UserServiceImpl implements UserService{
	
	private  UserRepository userRepository;
	private  ModelMapper modelMapper;
	private PassengerRepository passengerRepository;
	//@LoadBalanced
	private  RestTemplate restTemplate;
	
	public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper,RestTemplate restTemplate,
			PassengerRepository passengerRepository) {
		super();
		this.userRepository = userRepository;
		this.modelMapper = modelMapper;
		this.restTemplate =restTemplate;
		this.passengerRepository = passengerRepository;
	}
	
	/*public UserServiceImpl() {
		super();
		//this.userRepository = null;
		
	}*/
	@Override
	public FlightResponseDTO toBookFlight(UserDTO userDTO,int flightId) {
		ModelMapper modelMapper = new ModelMapper();
		PassengerDTO passengerDTO = new PassengerDTO();
		//UserRepository userRepository;
		userDTO.setPNR_Number(UUID.randomUUID().toString());
		userDTO.setFlightId(flightId);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		FlightRegistrationDTO flightRegistrationDTO =modelMapper.map(userDTO, FlightRegistrationDTO.class);
		//passengerDTO.setFlightRegistrationDTO(flightRegistrationDTO);
		userRepository.save(flightRegistrationDTO);
		//passengerRepository.saveAll(flightRegistrationDTO.getPassengers());
		
		return  modelMapper.map(flightRegistrationDTO,FlightResponseDTO.class);
	}



	@Override
	public List<SearchFlightResultDTO> searchFlight(SearchFlightDTO searchFlightDTO) throws URISyntaxException {
			//rest call of admin service
		URI uri = new URI("http://localhost:8084/api/v1.0/admin/flight/airline");
		List<SearchFlightResultDTO> finalList=new ArrayList<>();
		HttpEntity<SearchFlightDTO> entity = new HttpEntity<>(searchFlightDTO);
		ResponseEntity<SearchFlightResultDTO[]> data= restTemplate.exchange(uri.toString(), HttpMethod.POST, entity, SearchFlightResultDTO[].class);
		List<SearchFlightResultDTO> result =Arrays.asList(data.getBody());
		if(searchFlightDTO.isRoundTrip().equalsIgnoreCase("true")) {
		for(SearchFlightResultDTO dto :result) {
			
			int cost=	Integer.parseInt(dto.getFlightPrice())*2;
			dto.setFlightPrice(String.valueOf(cost));
			finalList.add(dto);
			}
		}
		return result;
	}


	
	@Override
	public FlightResponseDTO getFlightDetails(String pnr) {
		//Optional<FlightRegistrationDTO> flightRegistrationDTO = Optional.ofNullable(new FlightRegistrationDTO());
		
		Optional<FlightRegistrationDTO> flightRegistrationDTO = userRepository.findByPNR_Number(pnr);
		
		if(flightRegistrationDTO.isPresent()) {
			//passengerRepository.deleteByFlightId(flightRegistrationDTO.get().getId());
			return modelMapper.map(flightRegistrationDTO.get(), FlightResponseDTO.class);
		}else {
			
		return null;
		
		}
	}


	@Transactional
	@Override
	public void deleteFlightDetails(String pnr) {
		Optional<FlightRegistrationDTO> flightRegistrationDTO = userRepository.findByPNR_Number(pnr);
		if(flightRegistrationDTO.isPresent()) {
			passengerRepository.deleteByFlightId(flightRegistrationDTO.get().getId());
		}
	
		userRepository.deleteByPNR_Number(pnr);
		
	}



	@Override
	public List<FlightResponseDTO> getFlightBookingHistory(String emailId) {
		//List<FlightRegistrationDTO> flightDetails = new ArrayList<>();
		//dao call
		List<FlightRegistrationDTO> flightDetails= userRepository.findAllByEmailID(emailId);
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<FlightResponseDTO> flightResponseDTOList  = Arrays.asList(modelMapper.map(flightDetails, FlightResponseDTO[].class));
		
		return flightResponseDTOList;
	}


}
