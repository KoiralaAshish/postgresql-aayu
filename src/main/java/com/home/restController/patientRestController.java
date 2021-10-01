package com.home.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.Cases;
import com.home.model.Patient;
import com.home.repository.CasesRepo;
import com.home.repository.patientRepo;

@RestController
public class patientRestController {

	@Autowired
	patientRepo prepo;
	@Autowired
	CasesRepo crepo;
	
	@GetMapping("/api/patient/list")
	public List<Patient> getlist()
	{
		return prepo.findAll();
	}
	
	@GetMapping("/api/patient/edit/{id}")
	public Optional<Patient> getPatient(@PathVariable ("id") Integer id)
	{
		return prepo.findById(id);
	}
	
	@GetMapping("/api/patient/delete/{id}")
	public String deletePatient(@PathVariable ("id") Integer id)
	{
	 prepo.deleteById(id);
	 return "delete patient success";
	}
	
	
	@PostMapping("/api/patient/register")
	public String save(@RequestBody Patient p)
	{
		prepo.save(p);
		Cases c= new Cases();
		c.setPatient(p);
		c.setStatus("New");
		crepo.save(c);
		return "Patient added";
		
	}
	
	
	
}
