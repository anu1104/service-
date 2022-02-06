package com.flightadmin.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.flightadmin.dao.AdminRepository;
import com.flightadmin.dao.ImageRepository;
import com.flightadmin.dto.FlightDetailsDTO;
import com.flightadmin.dto.ImageDTO;
import com.flightadmin.dto.ResponseFlightDetailsDTO;
import com.flightadmin.dto.UserServiceRequestDTO;
import com.flightadmin.dto.UserServiceResponseDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	private final AdminRepository adminRepository;
	private final ModelMapper modelMapper;
	private final ImageRepository imageRepository;

	public AdminServiceImpl(AdminRepository adminRepository,ModelMapper modelMapper,ImageRepository imageRepository) {
		super();
		this.adminRepository = adminRepository;
		this.modelMapper= modelMapper;
		this.imageRepository=imageRepository;
	}

	@Override
	public ResponseFlightDetailsDTO addFlightDetails(FlightDetailsDTO flightDetailsDTO) {
		Random random = new Random();
		//flightDetailsDTO.setId( random.nextInt());
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		adminRepository.save(flightDetailsDTO);
		ResponseFlightDetailsDTO responseFlightDetailsDTO = modelMapper.map(flightDetailsDTO, ResponseFlightDetailsDTO.class);
		
		return responseFlightDetailsDTO;
	
}

	@Override
	public void blockedFlight(int flightNo) {
		adminRepository.setFlightDetailsByAirline(flightNo);
		
	}

	
	@Override
	public List<UserServiceResponseDTO> getFlightDetails(UserServiceRequestDTO userServiceRequestDTO) {
		
		UserServiceResponseDTO userServiceResponseDTO = new UserServiceResponseDTO();
		UserServiceResponseDTO userServiceResponseDTO2 = new UserServiceResponseDTO();
		List<UserServiceResponseDTO> list = new ArrayList<>();
		

		Date date = userServiceRequestDTO.getDate();
		
		LocalDate date1 = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		System.out.println("input date is "+date);
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		String s  =date1.format(format);
		System.out.println("actual date is"+s);
		Date date2=null;
		try {
			 date2=new SimpleDateFormat("dd-MM-yyyy").parse(s);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		//java.sql.Date sdate = java.sql.Date.valueOf(s);
		System.out.println("output date is "+date2);
		Date sdate =  new Date(2019-03-24);
		
		//System.out.println("new date is"+sdate);
		
		List<FlightDetailsDTO> listOfFlights=	adminRepository.getFlightDetails(
				userServiceRequestDTO.getFromPlace(),userServiceRequestDTO.getToPlace()	,s);
		System.out.println("dao list is "+listOfFlights);
		System.out.print(userServiceRequestDTO.getToPlace());
		//userServiceResponseDTO.setDate(sdate);
		
		for(int i=0;i<listOfFlights.size();i++) {
		userServiceResponseDTO.setDate(userServiceRequestDTO.getDate());
		userServiceResponseDTO.setFlightId(listOfFlights.get(i).getFlightNo());
		userServiceResponseDTO.setFlightName(listOfFlights.get(i).getFlightName());
		userServiceResponseDTO.setFlightPrice(String.valueOf(listOfFlights.get(i).getCost()));
		userServiceResponseDTO.setImageDTO(getFlightLogo(userServiceResponseDTO.getFlightName()));
		System.out.println(userServiceResponseDTO.getImageDTO());
		list.add(userServiceResponseDTO);
		}
		return list;
	}

	@Override
	public FlightDetailsDTO searchedFlight(int flightNo) {
		FlightDetailsDTO flight	=adminRepository.findByFlightNo(flightNo);
		return flight;
	}

	@Override
	public List<FlightDetailsDTO> viewAllFlights() {
		List<FlightDetailsDTO> flights = adminRepository.findAll();
		return flights;
	}	
	
	public ImageDTO getFlightLogo(String flightName) {
		final Optional<ImageDTO> retrievedImage = imageRepository.findByName(flightName);
		ImageDTO img = new ImageDTO(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()),retrievedImage.get().getFlightName());
		return img;
	}
	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}

}
