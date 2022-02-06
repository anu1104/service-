package com.apigateway.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.apigateway.dao.GatewayRepository;
import com.apigateway.dto.UserDTO;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	//private final GatewayRepository userRepository;
	private final RestTemplate restTemplate;
	
	

	public CustomUserDetailsService(RestTemplate restTemplate) {
		super();
		
		this.restTemplate=  restTemplate;
	}



	@Override
	public UserDetails loadUserByUsername(String username) {
		//UserDTO user = userRepository.findByUsername(username);
		
		URI uri=null;
		try {
			uri = new URI("http://localhost:9191/api/v1.0/flightmgmt/getUserData/"+username);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDTO user = restTemplate.getForObject(uri,UserDTO.class);
		if(user==null) {
			return new User("notfound","notfound",new ArrayList<>());
		}
		return new User(user.getUserName(),user.getUserPassword(),new ArrayList<>());
	}

}
