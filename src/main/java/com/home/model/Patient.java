package com.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patient_id;
	private String patient_name;
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	private String sex;
	private int age;
	private String blood_group;
	private String Patient_case;
	private String emergency_status;
	
	

	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getPatient_case() {
		return Patient_case;
	}
	public void setPatient_case(String patient_case) {
		Patient_case = patient_case;
	}
	public String getEmergency_status() {
		return emergency_status;
	}
	public void setEmergency_status(String emergency_status) {
		this.emergency_status = emergency_status;
	}
	
	
	
	
	
}
