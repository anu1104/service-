package com.flightmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightmgmt.dto.User;

@Repository
public interface FlightMgmtRepository extends JpaRepository<User,Long>{
	
	@Query
	public User findByUserName(String userName);

}
