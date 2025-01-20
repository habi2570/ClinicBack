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

import com.clinique.keneya.entity.Medicament;
import com.clinique.keneya.service.ServiceMedicament;

@RestController
@RequestMapping("/Medicament")

public class MedicamentController {
	@Autowired
	private ServiceMedicament serviceMedicament;
	@GetMapping("/all")
	private List<Medicament>getArrayList(){
		return this.serviceMedicament.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Medicament>getMedicament(@PathVariable Long id){
		Medicament medicament = serviceMedicament.findById(id);
		return ResponseEntity.ok(medicament);
	}
	@PostMapping("/nouveau")
	public ResponseEntity<Medicament>createMedicament(@RequestBody Medicament medicament){
		Medicament nouveauMedicament = serviceMedicament.save(medicament);
		return new ResponseEntity<>(nouveauMedicament,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Medicament>updateMedicament(@PathVariable Long id, @RequestBody Medicament medicament){
		Medicament medicamentMisAJour = serviceMedicament.update(id,medicament,id);
		return ResponseEntity.ok(medicament);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteMedicament(@PathVariable Long id){
		boolean estSupprime = serviceMedicament.delete(id);
		return ResponseEntity.noContent().build();
	}

}
