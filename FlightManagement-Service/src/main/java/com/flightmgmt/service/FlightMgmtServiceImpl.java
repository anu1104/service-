package com.flightmgmt.service;

import org.springframework.stereotype.Service;

import com.flightmgmt.dao.FlightMgmtRepository;
import com.flightmgmt.dto.User;

@Service
public class FlightMgmtServiceImpl implements  FlightMgmtService{
	
	private final FlightMgmtRepository repository;

	public FlightMgmtServiceImpl(FlightMgmtRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public void doRegistration(User user) {
		 
		repository.save(user);
		
	}

	@Override
	public User getRole(String username) {
		
		return	repository.findByUserName(username);
		 
	}

	@Override
	public User findByUserName(String username) {
		
		return repository.findByUserName(username);
	}
	
	
}
