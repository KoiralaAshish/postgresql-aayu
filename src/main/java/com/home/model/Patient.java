package com.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	@GeneratedValue
	private int patient_id;
	private String sex;
	private int age;
	private String bloodGroup;
	private String PatientCase;
	private String emergencyStatus;
	

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
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getPatientCase() {
		return PatientCase;
	}
	public void setPatientCase(String patientCase) {
		PatientCase = patientCase;
	}
	public String getEmergencyStatus() {
		return emergencyStatus;
	}
	public void setEmergencyStatus(String emergencyStatus) {
		this.emergencyStatus = emergencyStatus;
	}
	
	
	
	
	
	
}
