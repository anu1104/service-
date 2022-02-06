package com.flightadmin.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flightadmin.dto.FlightDetailsDTO;
import com.flightadmin.dto.UserServiceRequestDTO;
import com.flightadmin.dto.UserServiceResponseDTO;

@Repository
@Transactional
public interface AdminRepository extends JpaRepository<FlightDetailsDTO,Long>{
	
	@Modifying
	@Query(nativeQuery=true,value="delete from flight_details f  where f.flight_no=?1")
	public void setFlightDetailsByAirline(int  flightNo);
	
	@Query(nativeQuery=true,value="select "
			+ "* from flight_details f where   "
			+ "  f.from_place =?1 and f.to_place=?2 and Date(f.start_date) <=?3 and Date(f.end_date)>=?3 ")
	public List<FlightDetailsDTO> getFlightDetails(String fromPlace,String toPlace ,String s);
	
	@Query
	public FlightDetailsDTO findByFlightNo(int flightNo);

}
