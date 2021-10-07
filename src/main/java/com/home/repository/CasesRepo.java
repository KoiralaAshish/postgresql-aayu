package com.home.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.home.model.Cases;

public interface CasesRepo extends JpaRepository<Cases, Integer>{

	
	@Modifying
	@Transactional
	@Query(value="update cases set doctor_id=:doctor_id, status=:status where cases_id=:id",nativeQuery = true)
	void saveDoc( @Param("id") Integer id, @Param("doctor_id") Integer doctor_id, @Param("status") String status);

	
	@Modifying
	@Transactional
	@Query(value="update cases set doctor_id=null,status=:compl where cases_id=:id",nativeQuery = true)
	void deleteDoc(@Param("id") Integer id, @Param("compl") String compl);

@Query(value="select cases_id from cases where doctor_id =:id and status=:string",nativeQuery = true)
	Integer getcases(@Param("id")  Integer id, @Param("string") String string);
	
	
	
	
	
	

}
