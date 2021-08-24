package com.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.model.Patient;

public interface patientRepo extends JpaRepository<Patient, Integer>{

}
