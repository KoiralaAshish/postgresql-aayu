package com.home.repository;

import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.home.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	
	
	
	
	Users findByUsernameAndPassword(String un, String psw);
	
	@Query(value="select user_id from users where username=:un and password=:psw",nativeQuery = true)
	
	Integer userIdFind(@Param("un") String un, @Param ("psw") String psw);
	
@Query(value="select hospital_id from users where username=:un and password=:psw",nativeQuery = true)
	
	Integer hospitalIdFind(@Param("un") String un, @Param ("psw") String psw);



	
	
}
