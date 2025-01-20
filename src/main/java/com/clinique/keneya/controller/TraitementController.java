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

import com.clinique.keneya.entity.Traitement;
import com.clinique.keneya.service.ServiceTraitement;

@RestController
@RequestMapping("/Traitement")

public class TraitementController {
	@Autowired
	private ServiceTraitement serviceTraitement;
	@GetMapping("/all")
	private List<Traitement>getArrayList(){
		return this.serviceTraitement.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Traitement>getTraitementById(@PathVariable Long id){
		Traitement traitement = serviceTraitement.findById(id);
		return ResponseEntity.ok(traitement);
	}
	@PostMapping("/nouveau")
	public  ResponseEntity<Traitement>createTraitement(@RequestBody Traitement traitement){
		Traitement nouveauTraitement = serviceTraitement.save(traitement);
		return new ResponseEntity<>(nouveauTraitement,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Traitement>updateTraitement(@PathVariable Long id, @RequestBody Traitement traitement){
		Traitement traitementMisAJour = serviceTraitement.update(id,traitement,id);
		return ResponseEntity.ok(traitementMisAJour);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteTraitement (@PathVariable Long id){
		boolean estSupprime = serviceTraitement.delete(id);
		return ResponseEntity.noContent().build();
	}

}
