package com.home.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.home.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

	
	
	@Modifying
	@Transactional
	@Query(value="insert into department (available_bed, department_name, occupied_bed, ward, hospital_id)"+" VALUES (:a_bed,:name,:o_bed,:ward,:id)",nativeQuery = true)
			void savedepartmentIdHospital(@Param("id") Integer id, @Param("name") String name, @Param("ward") String ward, @Param("a_bed") Integer a_bed, @Param("o_bed") Integer o_bed);

	@Query(value="select hospital_id from department where department_id=:id", nativeQuery=true)
	Integer findhospitalID(@Param("id") Integer id);

	

	
	
	
	
}
