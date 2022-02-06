package com.flightuser.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightuser.dto.FlightRegistrationDTO;

@Repository
public interface UserRepository extends JpaRepository<FlightRegistrationDTO, Long>{
	
	@Query(nativeQuery=true,value="select * from flight_registration_details f where PNR_Number=?1")
	public Optional<FlightRegistrationDTO> findByPNR_Number(String pNR_Number);
	
	@Modifying
	@Query(nativeQuery=true,value="delete from flight_registration_details f where f.PNR_Number=?1")
	public void deleteByPNR_Number(String pNR_Number);
	
	@Query
	public List<FlightRegistrationDTO> findAllByEmailID(String emailId);


}
