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

import com.clinique.keneya.entity.Comptable;
import com.clinique.keneya.service.ServiceComptable;

@RestController
@RequestMapping("/comptables")
public class ComptableController {
	@Autowired
	private ServiceComptable serviceComptable;
	@GetMapping("/all")
	private List<Comptable>getArrayList (){
		return this.serviceComptable.getAll();
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Comptable> getComptableById(@PathVariable Long id){
		Comptable comptable = serviceComptable.findById(id);
		return ResponseEntity.ok(comptable);
		
	}
	@PostMapping("/nouveau")
	public ResponseEntity<Comptable>createComptable(@RequestBody Comptable comptable) {
		Comptable nouveauComptable = serviceComptable.save(comptable);
		return new ResponseEntity<>(nouveauComptable,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Comptable>updateComptable(@PathVariable Long id, @RequestBody Comptable comptable){
		Comptable comptableMisAJour = serviceComptable.update(id,comptable,id);
		return ResponseEntity.ok(comptableMisAJour);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteComptable(@PathVariable Long id){
		return ResponseEntity.noContent().build();
	}
	

}
