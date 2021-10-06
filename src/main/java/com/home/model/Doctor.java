package com.home.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Doctor {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;
private String doctor_name;
private byte[] image;
private String status;
private String availability;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
private String username;
private String password;


public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getAvailability() {
	return availability;
}
public void setAvailability(String availability) {
	this.availability = availability;
}
private String contact_phone;







public String getContact_phone() {
	return contact_phone;
}
public void setContact_phone(String contact_phone) {
	this.contact_phone = contact_phone;
}

public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}

public int getDoctor_id() {
	return doctor_id;
}
public void setDoctor_id(int doctor_id) {
	this.doctor_id = doctor_id;
}
public String getDoctor_name() {
	return doctor_name;
}
public void setDoctor_name(String doctor_name) {
	this.doctor_name = doctor_name;
}




	
	
	
	
	
	
	
}
