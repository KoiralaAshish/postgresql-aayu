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
	@Query(value="insert into doctor (doctor_name,contact_phone,department_id)"+" values(:name,:contact,:id)",nativeQuery = true)
			void saveDoctorDepartment(@Param("id") Integer id,@Param("contact") String contact, @Param("name")String name);

	
	
	@Query(value="select doctor_id from doctor where doctor_name=:name and contact_phone=:phone", nativeQuery = true)
	Integer getDoctorId(@Param("name") String name, @Param("phone") String phone );


@Modifying
@Transactional
@Query(value="update doctor set status=:sttus where doctor_id=:id", nativeQuery = true)
	void editStatus(@Param("id") Integer id, @Param("sttus") String sttus);


@Modifying
@Transactional
@Query(value="update doctor set status=:sttus,availability=:availability,contact_phone=:contact_phone,doctor_name=:doctor_name where doctor_id=:id", nativeQuery = true)
void edit(@Param("id") Integer id, @Param("sttus") String sttus,@Param("availability") String availability,@Param("contact_phone") String contact_phone,@Param("doctor_name") String doctor_name);


@Modifying
@Transactional
@Query(value="update doctor set availability=:availability where doctor_id=:id", nativeQuery = true)
void editAvailability(@Param("id") Integer id, @Param("availability") String availability);


@Query(value="select department_id from doctor where doctor_id=:doctor_id", nativeQuery = true)
Integer findDepartment(@Param("doctor_id") Integer doctor_id);
	
	
	

}
