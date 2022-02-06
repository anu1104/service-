package com.flightuser;

//import org.h2.server.web.WebServlet;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import com.flightuser.controller.UserController;
import com.flightuser.service.UserService;
import com.flightuser.service.UserServiceImpl;

@SpringBootApplication
public class FlightUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightUserServiceApplication.class, args);
	}
	
	@Bean
	//@LoadBalanced
	public RestTemplate getInstance() {
		return new RestTemplate();
	}
	
	
}
