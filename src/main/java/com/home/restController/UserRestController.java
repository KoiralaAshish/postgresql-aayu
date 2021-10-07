package com.home.restController;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.Hospital;
import com.home.model.Users;
import com.home.repository.HospitalRepo;
import com.home.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	private UserRepository urepo;
	@Autowired
	private HospitalRepo hrepo;
	
	
	
	@GetMapping("/api/user/list")
	public List<Users> getAllUser()
	{
		return urepo.findAll();
		
	}
	
	@PostMapping("/api/user/login")
	public Integer loginInfo(@RequestBody Users u)
	{
		
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		
		if(urepo.findByUsernameAndPassword(u.getUsername(), u.getPassword()) == null)
			
		{

			return 54545;
		}
		
		
		else
		{
		
			return urepo.hospitalIdFind(u.getUsername(), u.getPassword());
			
					
		}
		
				
	}
			
	
	@PostMapping("/api/user/register")
	public Integer addUser(@RequestBody Users u)
	{
		
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
				
		
		
		Hospital h= new Hospital();
		
		hrepo.save(h);
		u.setHospital(h);
		
		
		
		urepo.save(u);
		
		
		return urepo.hospitalIdFind(u.getUsername(), u.getPassword());
			
	}
	     

	
	
	
	
	
	
	
	
	
}
