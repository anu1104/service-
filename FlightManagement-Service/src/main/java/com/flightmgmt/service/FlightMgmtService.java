package com.flightmgmt.service;

import org.springframework.stereotype.Service;

import com.flightmgmt.dto.User;

@Service
public interface FlightMgmtService {

	void doRegistration(User user);

	User getRole(String username);

	User findByUserName(String username);

}
