package com.home.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.Hospital;
import com.home.repository.HospitalRepo;

@RestController
@CrossOrigin(origins = "*")
public class HospitalrestController {
	
	@Autowired
	private HospitalRepo hrepo;
	

	@GetMapping("/api/hospital/list")
	public List<Hospital> getList()
	{
		return hrepo.findAll();
	}

	@GetMapping("/api/hospital/{hospitalId}")
	public String getHospitalList(@PathVariable ("hospitalId") Integer hospitalId,@RequestBody Hospital h)
	{
		h.setHospital_id(hospitalId);
		h.setHospital_name(h.getHospital_name());
		hrepo.save(h);
		return "edit success";
	}
	
	
	@PostMapping("/api/hospital/register")
	public Integer addHospital(@RequestBody Hospital h)
	{
		
		Integer a= hrepo.hospitalIdFind(h.getHospital_name());
		
		if(a==null)
		{
			
			hrepo.save(h);
			return hrepo.hospitalIdFind(h.getHospital_name());
		}
		
		else
		{
			return a;
			
		}
	}
		
		@PostMapping("/api/hospital/register/{hospital_id}")
		public Integer addHospitalregister(@PathVariable ("hospital_id") Integer hospital_id, @RequestBody Hospital h)
		{
			
			h.setHospital_id(hospital_id);
			h.setHospital_name(h.getHospital_name());
			hrepo.save(h);
			
			return hrepo.hospitalIdFind(h.getHospital_name());
					
	}
	

	@PostMapping("/api/hospital/userHospitalRegister")
	public String adduserHospital(@RequestBody Hospital h)
	{
		
		hrepo.save(h);
		
		return "new hospital added";
		
		
	}
	
	
		
}
