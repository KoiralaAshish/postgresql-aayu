package com.home.restController;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.Doctor;
import com.home.repository.CasesRepo;
import com.home.repository.DoctorRepo;

@RestController
@CrossOrigin(origins = "*")
public class DoctorRestController {

	@Autowired
	private DoctorRepo drrepo;
	@Autowired
	private CasesRepo crepo;
	
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
	
	
	@GetMapping("/api/doctor/delete/{doctorId}")
	public String deleteDoctorById(@PathVariable("doctorId") Integer doctor_id)
	{
		 drrepo.deleteById(doctor_id);	
		return "doctor deleted";
	}
	
	@PostMapping("/api/doctor/register")
	public String addDoctor(@RequestBody Doctor d)
	{
		d.setPassword(DigestUtils.md5DigestAsHex(d.getPassword().getBytes()));
		drrepo.save(d);
		return "doctor added";
	}
	
	@PostMapping("/api/doctor/register/{department_id}")
	public Integer saveDoctor(@PathVariable("department_id") String department_id, @RequestBody Doctor d)
	{
		Integer id= Integer.parseInt(department_id);
		String contact= d.getContact_phone();
		String name= d.getDoctor_name();
		String availability= d.getAvailability();
		String status=d.getStatus();
		Random ran= new Random();
		d.setUsername("doctor"+name+ran.nextInt(1000));
		String username= d.getUsername();
		String password=d.getPassword();
	
		
		drrepo.saveDoctorDepartment(id,contact,name,availability,status,username,password);	
		
		Integer a=drrepo.getDoctorId(d.getDoctor_name(),d.getContact_phone());
		return a;
		
		
	}
	
	
	
	@PostMapping("/api/doctor/editstatus/{doctor_id}")
	public String changeStatus(@PathVariable("doctor_id") String doctor_id, @RequestBody Doctor d)
	{
		Integer id= Integer.parseInt(doctor_id);
		
		drrepo.editStatus(id, d.getStatus());
		
		return "status edited";
		
		
	}
	
	@PostMapping("/api/doctor/edit/{doctor_id}")
	public String change(@PathVariable("doctor_id") String doctor_id, @RequestBody Doctor d)
	{
		Integer id= Integer.parseInt(doctor_id);
		
		drrepo.edit(id, d.getStatus(), d.getAvailability(),d.getContact_phone(),d.getDoctor_name());
		
		return "status edited";
		
	}
	
	@PostMapping("/api/doctor/editavailability/{doctor_id}")
	public String changeAvailability(@PathVariable("doctor_id") String doctor_id, @RequestBody Doctor d)
	{
		Integer id= Integer.parseInt(doctor_id);
		
		drrepo.editAvailability(id, d.getAvailability());
		
		return "status edited";
		
	}
	
	@GetMapping("/api/doctor/getdepartment/{doctor_id}")
	public Integer getDepartmentId(@PathVariable("doctor_id") String doctor_id)
	{
		Integer id= Integer.parseInt(doctor_id);
	return 	drrepo.findDepartment(id);
	
	}
	
	@PostMapping("/api/doctor/doctordetails")
	public Optional<Doctor> getDoctorDetails (@RequestBody Doctor d)
	{
		Optional<Doctor> doc= drrepo.getdoctordetails(d.getUsername());
		
		return doc;		
	}
	
	
	@PostMapping("/api/doctor/addpassword/{doctor_id}")
	public String addPassword(@PathVariable("doctor_id") String doctor_id, @RequestBody Doctor d)
	{
		Integer id= Integer.parseInt(doctor_id);
		d.setPassword(DigestUtils.md5DigestAsHex(d.getPassword().getBytes()));
		drrepo.savepassword(d.getPassword(),id);
		
		return "updated password";
	}
	
	
	@PostMapping("/api/doctor/checkdoctor")
	public String loginDoctor(@RequestBody Doctor d)
	{
		d.setPassword(DigestUtils.md5DigestAsHex(d.getPassword().getBytes()));
		
		if(drrepo.findByUsernameAndPassword(d.getUsername(), d.getPassword())==null)
		{
			return "false";
		}
		else
		{
			return "true";
		}
			
	}
	
	
	
	@PostMapping("/api/doctor/getcases")
	public Integer getcases( @RequestBody Doctor d)
	{
		
		
		return crepo.getcases(d.getDoctor_id(),"Active");
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
