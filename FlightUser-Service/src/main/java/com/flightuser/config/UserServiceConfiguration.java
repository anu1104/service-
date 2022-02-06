package com.flightuser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flightuser.service.UserService;
import com.flightuser.service.UserServiceImpl;

import org.modelmapper.ModelMapper;

@Configuration
public class UserServiceConfiguration {
	
	@Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    } 
	
	/*@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}*/

}
