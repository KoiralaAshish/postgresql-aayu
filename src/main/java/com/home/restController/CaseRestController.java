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

import com.home.model.Cases;
import com.home.model.Doctor;
import com.home.repository.CasesRepo;

@RestController
@CrossOrigin(origins = "*")
public class CaseRestController {
	
	@Autowired
	private CasesRepo crepo;
	
	@GetMapping("/api/cases/list")
	public List<Cases> getAll()
	{
		return crepo.findAll();
		
	}
	@PostMapping("/api/cases/register")
	public void caseId(@RequestBody Cases c)
	{
		crepo.save(c);
		
		
		
	}
	
	@GetMapping("/api/cases/delete/{id}")
	public String deleteCases(@PathVariable ("id") Integer id)
	{
		crepo.deleteById(id);
		return "Case Deleted";
	}
	
	@GetMapping("/api/cases/edit/{id}")
	public Optional<Cases> editCases(@PathVariable ("id") Integer id)
	{
		return crepo.findById(id);
	
		
	}
	
	@PostMapping("/api/cases/doctor/{cases_id}")
	public String addDoctor(@PathVariable ("cases_id") String cases_id,@RequestBody Doctor d)
	{
		Integer id= Integer.parseInt(cases_id);
		d.setStatus("Active");
	crepo.saveDoc(id,d.getDoctor_id(),d.getStatus());
		
		
		return "added";
		
	}
	
	@PostMapping("/api/cases/delete_doctor")
	public String deleteDoctor(@RequestBody Cases c)
	{
		c.setStatus("Completed");
		
	crepo.deleteDoc(c.getCases_id(),c.getStatus());
		
		
		return "deleted";
		
		
	}
	
	

}
