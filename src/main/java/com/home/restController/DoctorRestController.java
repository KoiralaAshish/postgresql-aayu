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

import com.home.model.Doctor;
import com.home.repository.DoctorRepo;

@RestController
@CrossOrigin(origins = "*")
public class DoctorRestController {

	@Autowired
	private DoctorRepo drrepo;
	
	@GetMapping("/api/doctor/list")
	public List<Doctor> findall()
	{
	return drrepo.findAll();
	}
	
	@GetMapping("/api/doctor/{doctorId}")
	public Optional<Doctor> getDoctorById(@PathVariable("doctorId") Integer doctor_id)
	{
		return drrepo.findById(doctor_id);	
		
	}
	
	@PostMapping("/api/doctor/register")
	public String addDoctor(@RequestBody Doctor d)
	{
		drrepo.save(d);
		return "doctor added";
	}
	
	
	
	
}
