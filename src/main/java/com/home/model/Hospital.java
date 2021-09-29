package com.home.model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;




@Entity
public class Hospital {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int hospital_id;
private String hospital_name;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "hospital_id")
private Set<Department> department = new HashSet<>();



public Set<Department> getDepartment() {
	return department;
}

public void setDepartment(Set<Department> department) {
	this.department = department;
}

public int getHospital_id() {
	return hospital_id;
}

public void setHospital_id(int hospital_id) {
	this.hospital_id = hospital_id;
}

public String getHospital_name() {
	return hospital_name;
}

public void setHospital_name(String hospital_name) {
	this.hospital_name = hospital_name;
}















}
