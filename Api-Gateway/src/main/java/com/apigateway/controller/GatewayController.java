package com.apigateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apigateway.config.JwtUtil;
import com.apigateway.dto.AuthRequestDTO;
import com.apigateway.service.CustomUserDetailsService;

@RestController
@CrossOrigin(origins="http//localhost:4200")
public class GatewayController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final CustomUserDetailsService userService;
	private final AuthRequestDTO authRequest;
	
	
	public GatewayController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
			CustomUserDetailsService userService,AuthRequestDTO authRequest) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
		this.userService=userService;
		this.authRequest=authRequest;
	}

	@GetMapping("/")
	public String welcome() {
		
		return "welcome to flight management system";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> generateToken(@RequestBody AuthRequestDTO authRequestDTO) throws Exception {
		/*try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(),
				authRequestDTO.getPassword()));
		}catch(Exception e){
			throw new Exception("Invalid usernamr and password");
			
		}*/
		
		final UserDetails userDetails =userService.loadUserByUsername(authRequestDTO.getUsername());
		if(!userDetails.getUsername().equalsIgnoreCase(authRequestDTO.getUsername()) ||
				!userDetails.getPassword().equalsIgnoreCase(authRequestDTO.getPassword())) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Credentials");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(jwtUtil.generateToken(userDetails));
		
	}

}
