package com.project.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.dto.ProjectDTO;
import com.project.model.ProjectDetailsModel;
import com.project.queries.ProjectQuery;

public interface ProjectRepository extends JpaRepository<ProjectDTO, Integer> {
	
	@Query(nativeQuery=true, value="select from project_details where id in(:projectIds)")
	public List<ProjectDTO> findProjectDetailsById(@Param("projectIds") List<Integer> projectIds);
	
	@Query(nativeQuery=true, value=ProjectQuery.query)
	public List<ProjectDetailsModel> getAllDetails();

}
