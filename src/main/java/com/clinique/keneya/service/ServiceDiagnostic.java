package com.clinique.keneya.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.DiagnosticDao;
import com.clinique.keneya.dao.PatientDao;
import com.clinique.keneya.entity.Diagnostic;
import com.clinique.keneya.entity.Patient;

@Service
public class ServiceDiagnostic {
	@Autowired
	public DiagnosticDao diagnosticDao;
	@Autowired
	public PatientDao patientDao;
	
	
	public List<Diagnostic> getAll() {
		return this.diagnosticDao.findAll();
	}

	public Diagnostic findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Diagnostic save(Diagnostic diagnostic,Long id) {
		
		Patient patient=this.patientDao.getOne(id); 
		System.out.println(diagnostic);
		diagnostic.setDate(LocalDate.now());
		diagnostic=diagnosticDao.save(diagnostic);
		patient.getDiagnostics().add(diagnostic);
		patientDao.save(patient);
		return diagnostic;
	}

	public Diagnostic update(Long id, Diagnostic diagnostic, Long id2) {
		// TODO Auto-generated method stub
		return diagnosticDao.save(diagnostic);
	}

}
