package com.home.model;



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;


@Entity
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int department_id;
	
		
	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	private String department_name;
private int available_bed;
private int occupied_bed;
private String ward;

@OneToMany( cascade = CascadeType.ALL)
@JoinColumn(name = "DepartmentId")
private Set<Doctor> doctor;
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "DepartmentId")
private Set<Patient> patient;
@OneToMany( cascade = CascadeType.ALL)
@JoinColumn(name = "DepartmentId")
private Set<Cases> patientCases;










	public Set<Doctor> getDoctor() {
	return doctor;
}

public void setDoctor(Set<Doctor> doctor) {
	this.doctor = doctor;
}

public Set<Patient> getPatient() {
	return patient;
}

public void setPatient(Set<Patient> patient) {
	this.patient = patient;
}

public Set<Cases> getPatientCases() {
	return patientCases;
}

public void setPatientCases(Set<Cases> patientCases) {
	this.patientCases = patientCases;
}

	public int getAvailable_bed() {
	return available_bed;
}

public void setAvailable_bed(int available_bed) {
	this.available_bed = available_bed;
}

public int getOccupied_bed() {
	return occupied_bed;
}

public void setOccupied_bed(int occupied_bed) {
	this.occupied_bed = occupied_bed;
}

public String getWard() {
	return ward;
}

public void setWard(String ward) {
	this.ward = ward;
}

	

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	
	

}
