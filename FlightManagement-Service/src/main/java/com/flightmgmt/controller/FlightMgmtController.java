package com.flightmgmt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightmgmt.dto.User;
import com.flightmgmt.service.FlightMgmtService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1.0/flightmgmt")
public class FlightMgmtController {
	
	private final FlightMgmtService service;

	public FlightMgmtController(FlightMgmtService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/hello")
	public String getString() {
		return "anu";
	}
	
	@PostMapping("/registration")
	public ResponseEntity<String> doRegistration(@RequestBody User user ){
		
		service.doRegistration(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Registration has been successfuly Created");
		
	}
	
@GetMapping("getRole")	
public ResponseEntity<User> getUserRole (@RequestParam("username") String  username ){
		
		User user = service.getRole(username);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		
		
		
	}

@GetMapping("/getUserData/{username}")
public ResponseEntity<User> findByUserName(@PathVariable ("username") String username) {

User user = service.findByUserName(username);

return ResponseEntity.status(HttpStatus.OK).body(user);
}
}


