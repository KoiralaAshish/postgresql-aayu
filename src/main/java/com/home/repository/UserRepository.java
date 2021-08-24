package com.home.repository;

import java.util.Random;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.home.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	Random rand= new Random();
	int n = rand.nextInt(10);
	
	
	
	User findByUsernameAndPassword(String un, String psw);
	
	@Query(value="select user_id from user where username=:un and password=:psw",nativeQuery = true)
	
	Integer userIdFind(@Param("un") String un, @Param ("psw") String psw);
	
@Query(value="select hospital_id from user where username=:un and password=:psw",nativeQuery = true)
	
	Integer hospitalIdFind(@Param("un") String un, @Param ("psw") String psw);
	
	
@Query(value="update user set hospital_id=1 where username=:un and password=:psw and hospital.hospital_id=user.user_id",nativeQuery = true)
	
	void hospitalSave(@Param("un") String un, @Param ("psw") String psw);
	
}
