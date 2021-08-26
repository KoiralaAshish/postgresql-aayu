package com.home.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cases {
@Id
@GeneratedValue
	private int cases_id;
	private String status;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patient_id")
	private Patient patient;
	
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
