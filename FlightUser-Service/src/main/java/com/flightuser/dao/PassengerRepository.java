package com.flightuser.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flightuser.dto.PassengerDTO;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerDTO,Long> {
	@Modifying
    @Transactional
	@Query(nativeQuery=true,value="delete from passenger_details p where p.flight_id=?1")
	public void deleteByFlightId(int flight_id);
	
	

}
