package com.apigateway;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.apigateway.dao.GatewayRepository;
import com.apigateway.dto.UserDTO;

@SpringBootApplication
public class ApiGatewayApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
	/*@PostConstruct
	public void initUsers() {
		List<UserDTO> list = Stream.of(
				new UserDTO(101,"abc","password","abc@gmail.com"),
				new UserDTO(102,"xyz","password1","xyz@gmail.com"))
				.collect(Collectors.toList());
		
		repository.saveAll(list);
		
	}*/

}
