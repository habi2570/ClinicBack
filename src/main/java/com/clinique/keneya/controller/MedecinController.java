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
import org.springframework.web.bind.annotation.RestController;

import com.clinique.keneya.entity.Infirmier;
import com.clinique.keneya.entity.Medecin;
import com.clinique.keneya.service.ServiceMedecin;

@RestController
@RequestMapping("/Medecin")

public class MedecinController {
	@Autowired
	private ServiceMedecin serviceMedecin;
	@GetMapping("/all")
	private List<Medecin>getArrayList(){
		return this.serviceMedecin.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Medecin>getMedecinById(@PathVariable Long id){
		Medecin medecin = serviceMedecin.findById(id);
		return ResponseEntity.ok(medecin);
	}
	@PostMapping("/nouveau")
	public ResponseEntity<Medecin>createMedecin(@RequestBody Medecin medecin){
		Medecin nouveauMedecin = serviceMedecin.save(medecin);
		System.out.println(12567);
		return new ResponseEntity<>(nouveauMedecin,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Medecin>updateMedecin(@PathVariable Long id, @RequestBody Medecin medecin){
		Medecin medecinMisAJour = serviceMedecin.update(id,medecin,id);
		return ResponseEntity.ok(medecinMisAJour);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteMedecin(@PathVariable Long id){
		boolean estSupprime = serviceMedecin.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
