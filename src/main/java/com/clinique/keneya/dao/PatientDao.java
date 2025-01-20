package com.clinique.keneya.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinique.keneya.entity.Patient;

public interface PatientDao extends JpaRepository< Patient,Long>{

	List<Patient> findByNom(String nom);
	List<Patient> findByNomStartsWithIgnoreCase(String nom);
}
