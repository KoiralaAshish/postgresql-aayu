
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

import com.home.model.Department;
import com.home.repository.DepartmentRepo;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentRestController {
@Autowired
	private DepartmentRepo drepo;
	
	
	
@PostMapping("/api/department/register")
public String addDepartment(@RequestBody Department d)
{
	drepo.save(d);
	
	return "Department add success";
		
}

@PostMapping("/api/department/addDepartmentHospital/{id}")
public String addDepartmentwithHospitalId(@PathVariable ("id") String id,@RequestBody Department d)
{
	Integer hospital_id= Integer.parseInt(id);
	
	
	String name= d.getDepartment_name();
	String ward= d.getWard();
	Integer a_bed= d.getAvailable_bed();
	Integer o_bed= d.getOccupied_bed();
	
	drepo.savedepartmentIdHospital(hospital_id,name, ward, a_bed, o_bed);
	
	return "Department add success";
		
}

@GetMapping("/api/department/edit/{id}")
public Optional<Department> editDepartment(@PathVariable ("id") Integer id)
{
	
	return drepo.findById(id);
	
	
}


@GetMapping("/api/department/delete/{id}")
public String deleteDepartment(@PathVariable ("id") Integer id)
{
drepo.deleteById(id);
return "Deleted Department";

}

@GetMapping("/api/department/list")
public List<Department> showDepartment()
{
	return drepo.findAll();
}


@GetMapping("/api/department/gethospital/{department_id}")
public Integer getHospitalId(@PathVariable ("department_id") String department_id)
{
	Integer id= Integer.parseInt(department_id);
	return drepo.findhospitalID(id);
	
}


	
	
	
}
