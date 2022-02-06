package com.flightadmin.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flightadmin.dao.ImageRepository;
import com.flightadmin.dto.FlightDetailsDTO;
import com.flightadmin.dto.ImageDTO;
import com.flightadmin.dto.RequestFlightDetailsDTO;
import com.flightadmin.dto.ResponseFlightDetailsDTO;
import com.flightadmin.dto.UserServiceRequestDTO;
import com.flightadmin.dto.UserServiceResponseDTO;
import com.flightadmin.service.AdminService;

@RestController
@CrossOrigin(origins="http//localhost:4200")
@RequestMapping("/api/v1.0/admin/flight")
public class AdminController {
	
	private final AdminService adminService;
	private final ModelMapper modelMapper;
	private final ImageRepository imageRepository;
	
	public AdminController(AdminService adminService, ModelMapper modelMapper,ImageRepository imageRepository) {
		super();
		this.adminService = adminService;
		this.modelMapper = modelMapper;
		this.imageRepository=imageRepository;
	}
	
	@GetMapping("/")
	public String getString() {
		return "anu";
	}
	@PostMapping("/airline/inventory/add")
	public ResponseEntity<ResponseFlightDetailsDTO> addFlightSchedule(@RequestBody RequestFlightDetailsDTO
			requestFlightDetailsDTO){
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		FlightDetailsDTO flightDetailsDTO = modelMapper.map(requestFlightDetailsDTO, FlightDetailsDTO.class);
		
		ResponseFlightDetailsDTO responseFlightDetailsDTO = adminService.addFlightDetails(flightDetailsDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(responseFlightDetailsDTO);
	}
	
	@DeleteMapping("/airline/inventory/block/{flightNo}")
	public String blockedAirline(@PathVariable("flightNo") int flightNo) {
		
		adminService.blockedFlight(flightNo);
		return "Flight has blocked";
	}
	
	@GetMapping("/airline/inventory/search/{flightNo}")
	public ResponseEntity<FlightDetailsDTO> searchFlight(@PathVariable("flightNo") int flightNo
			//@RequestHeader("Access-Control-Allow-Origin") String req
			) {
		
		FlightDetailsDTO flightDetails = adminService.searchedFlight(flightNo);
		return ResponseEntity.status(HttpStatus.OK).body(flightDetails);
	}
	
	@GetMapping("/airline/inventory/viewAll")
	public ResponseEntity<List<FlightDetailsDTO>> searchAllFlights() {
		
		List<FlightDetailsDTO> flightDetails = adminService.viewAllFlights();
		return ResponseEntity.status(HttpStatus.OK).body(flightDetails);
	}
	
	@PostMapping("/airline")
	public ResponseEntity<List<UserServiceResponseDTO>> getFlightDetails(@RequestBody UserServiceRequestDTO 
			userServiceRequestDTO){
		
	List<UserServiceResponseDTO> userServiceResponseDTO = adminService.getFlightDetails(userServiceRequestDTO);
		return ResponseEntity.status(HttpStatus.OK).body(userServiceResponseDTO);
	}
	
	@PostMapping("/image/upload/{flightName}")
	public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file,@PathVariable("flightName") String flightName) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageDTO img = new ImageDTO(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()),flightName);
		imageRepository.save(img);
		return ResponseEntity.status(HttpStatus.OK);
	}
	
	@GetMapping(path = { "/image/get/{flightName}" })
	public ImageDTO getImage(@PathVariable("flightName") String flightName) throws IOException {

		final Optional<ImageDTO> retrievedImage = imageRepository.findByName(flightName);
		ImageDTO img = new ImageDTO(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()),retrievedImage.get().getFlightName());
		return img;
	}

	


	// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}
	
	// uncompress the image bytes before returning it to the angular application
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

