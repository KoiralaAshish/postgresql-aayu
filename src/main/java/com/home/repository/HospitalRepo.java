package com.home.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.home.model.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {
	
	
	
	@Query(value="select hospital_id from hospital where hospital_name=:name",nativeQuery = true)
	Integer hospitalIdFind(@Param("name") String name);
	
	
	
	

}
