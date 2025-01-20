package com.clinique.keneya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clinique.keneya.entity.Patient;
import com.clinique.keneya.service.ServicePatient;

@RestController
@RequestMapping("/Patient")

public class PatientController {
	private static final String Http = null;
	@Autowired
	private ServicePatient servicePatient;
	@GetMapping("/all")
	private List<Patient>findAllPatient(){
		return this.servicePatient.getAll();
	}
	
	@GetMapping("/ByNom/{nom}")
	private List<Patient>findByNom(@PathVariable String nom){
		return this.servicePatient.getByNom(nom);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Patient>getPatientById(@PathVariable Long id){
		Patient patient = servicePatient.findById(id);
		return ResponseEntity.ok(patient);
	}
	@PostMapping("/nouveau")
	public ResponseEntity<Patient>createPatient(@RequestBody Patient patient){
		for(int i=0;i<100000;i++) {
			System.out.println(i);
		}
		Patient nouveauPatient = servicePatient.save(patient);
		return new ResponseEntity<>(nouveauPatient,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Patient>updatePatient(@PathVariable Long id, @RequestBody Patient patient){
		Patient patientMisAJour = servicePatient.update(id,patient,id);
		return ResponseEntity.ok(patientMisAJour);
	}
	@GetMapping("/supprimer/{id}")
	public ResponseEntity<Boolean> deletePatient(@PathVariable Long id){
		servicePatient.delete(id);
		System.out.println("jh");
		return ResponseEntity.ok(true);
	}
	
	

}
