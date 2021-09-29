package com.home.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.home.model.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer>{

	
	
	
	@Modifying
	@Transactional
	@Query(value="insert into doctor (doctor_name,contact_phone,department_id)"+" values(:name.:contact,:id)",nativeQuery = true)
			void saveDoctorDepartment(@Param("id") Integer id,@Param("contact") String contact, @Param("name")String name);

	
	
	@Query(value="select doctor_id from doctor where doctor_name=:name and contact_phone=:phone", nativeQuery = true)
	Integer getDoctorId(@Param("name") String name, @Param("phone") String phone );
	
	
	

}
