package com.clinique.keneya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.PatientDao;
import com.clinique.keneya.entity.Patient;

import javax.transaction.Transactional;

@Service
@Transactional
public class ServicePatient {
	@Autowired
	public PatientDao patientDao;

	public List<Patient> getAll() {
		return this.patientDao.findAll();
	}
	
	public List<Patient> getByNom(String nom) {
		return this.patientDao.findByNomStartsWithIgnoreCase(nom);
	}

	public Patient findById(Long id) {
		return null;
	}

	public Patient save(Patient patient) {
		return patientDao.save(patient);
	}

	public Patient update(Long id, Patient patient, Long id2) {
		return patientDao.save(patient);
	}
	public  Patient delete(Long id, Patient patient, Long id2) {
		return patientDao.save(patient);
		
	}

	public void delete(Long id) {
		 patientDao.deleteById(id);;
	}


}
