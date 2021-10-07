package com.home.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.Appuser;
import com.home.repository.AppUserrepo;

@RestController
public class AppuserRestController {
	
	@Autowired
	AppUserrepo arepo;
	
	
	@PostMapping("/api/appuser/signup")
	public Integer saveAppUser(@RequestBody Appuser u)
	{
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		arepo.save(u);
		Integer a=arepo.getID(u.getPhone());
		return a;
		
	}
	
	
	@PostMapping("/api/appuser/login")
	public Integer checkAppUser(@RequestBody Appuser u)
	{
		
		u.setPassword(DigestUtils.md5DigestAsHex(u.getPassword().getBytes()));
		
		if(arepo.findByPhoneAndPassword(u.getPhone(),u.getPassword()) == null)
		{
			return 5555;
		}
		else
		{
			return arepo.getID(u.getPhone());
		}
			
			
		
		
		
	}
	
	
	
	
	
	

}
