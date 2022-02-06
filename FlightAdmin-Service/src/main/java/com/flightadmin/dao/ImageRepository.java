package com.flightadmin.dao;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightadmin.dto.ImageDTO;

public interface ImageRepository extends JpaRepository<ImageDTO, Long> {
	@Query(nativeQuery=true,value="select * from image_table i where i.flight_name=?1" )
	Optional<ImageDTO> findByName(String name);

}
