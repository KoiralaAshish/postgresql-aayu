package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.home.model.Appuser;


public interface AppUserrepo extends JpaRepository<Appuser, Integer> {

	
	
	@Query(value="select user_id from appuser where phone=:phone",nativeQuery = true )
	Integer getID(@Param("phone") String phone);

	Appuser findByPhoneAndPassword(String phone, String password);

}
