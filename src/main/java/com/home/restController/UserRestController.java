package com.home.restController;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.Hospital;
import com.home.model.User;
import com.home.repository.HospitalRepo;
import com.home.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	private UserRepository urepo;
	
	
	
	@GetMapping("/api/user/list")
	public List<User> getAllUser()
	{
		return urepo.findAll();
		
	}
	
	@PostMapping("/api/user/login")
	public Integer loginInfo(@RequestBody User u)
	{
		
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		
		if(urepo.findByUsernameAndPassword(u.getUsername(), u.getPassword()) == null)
			
		{
//			List<User> u1 = new ArrayList<User>();
//			 return u1;
			return 54545;
		}
		
		
		else
		{
		
			return urepo.hospitalIdFind(u.getUsername(), u.getPassword());
			
			
		
		}
		
				
	}
			
	
	@PostMapping("/api/user/register")
	public Integer addUser(@RequestBody User u)
	{
		
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
				
		
		urepo.save(u);
		
		
		return urepo.userIdFind(u.getUsername(), u.getPassword());
			
	}
	     
//	
//	@PostMapping("/api/user/hospregister")
//	public Integer addHospUser(@RequestBody User u)
//	{
//		
//		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
//				
//		
//		urepo.save(u);
//		
//		urepo.hospitalSave(u.getUsername(), u.getPassword());
//		Integer i= urepo.userIdFind(u.getUsername(), u.getPassword());
//		return i;
//		
//			
//	}
//	
//	
	
	
	
	
	
	
	
	
	
}
