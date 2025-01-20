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
import com.clinique.keneya.service.ServiceInfirmier;

@RestController
@RequestMapping("/Infirmier")

public class InfirmierController {
	@Autowired
	private ServiceInfirmier serviceInfirmier;
	@GetMapping("/all")
	private List<Infirmier>getArrayList(){
		return this.serviceInfirmier.getAll();
		}
	@GetMapping("/{id}")
	public ResponseEntity<Infirmier>getInfirmierById(@PathVariable Long id){
		Infirmier infirmier = serviceInfirmier.findById(id);
		return ResponseEntity.ok(infirmier);
	}
	@PostMapping("/nouveau")
	public ResponseEntity<Infirmier>createInfirmier(@RequestBody Infirmier infirmier){
		Infirmier nouveauInfirmier = serviceInfirmier.save(infirmier);
		return new ResponseEntity<>(nouveauInfirmier,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Infirmier>updateInfirmier(@PathVariable Long id,@RequestBody Infirmier infirmier){
		Infirmier infirmierMisAJour = serviceInfirmier.update(id,infirmier,id);
		return ResponseEntity.ok(infirmierMisAJour);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable Long id){
		boolean estSupprimer = serviceInfirmier.delete(id);
		return ResponseEntity.noContent().build();
	}

}
