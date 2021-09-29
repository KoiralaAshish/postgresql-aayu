package com.home.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cases {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cases_id;
	private String status;
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	private String Location;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	

	
	
	public int getCases_id() {
		return cases_id;
	}
	public void setCases_id(int cases_id) {
		this.cases_id = cases_id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
	
	
	
	
	
	
	
}
