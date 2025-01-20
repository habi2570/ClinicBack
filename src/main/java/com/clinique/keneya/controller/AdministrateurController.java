package com.clinique.keneya.controller;

import java.util.Collection;
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

import com.clinique.keneya.entity.Administrateur;
import com.clinique.keneya.entity.AppUser;
import com.clinique.keneya.entity.Comptable;
import com.clinique.keneya.entity.Infirmier;
import com.clinique.keneya.entity.Medecin;
import com.clinique.keneya.service.ServiceAdministrateur;

@RestController
@RequestMapping("/administrateur")

public class AdministrateurController {
	@Autowired
	private ServiceAdministrateur serviceAdministrateur;
	@GetMapping("/all")
	private List<Administrateur>getArrayList(){
		return this.serviceAdministrateur.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Administrateur>getAdministrateurById(@PathVariable Long id){
		Administrateur administrateur =serviceAdministrateur.findById(id);
		return ResponseEntity.ok(administrateur);
	}
	@PostMapping("/nouveau")
	public ResponseEntity<Administrateur> createAdministrateur(@RequestBody Administrateur administrateur){
		Administrateur nouveauAdministrateur =serviceAdministrateur.save(administrateur);
		return new ResponseEntity<>(nouveauAdministrateur,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Administrateur> updateAdministrateur(@PathVariable Long id, @RequestBody Administrateur administrateur){
		Administrateur administrateurMisAJour = serviceAdministrateur.update(id, administrateur,id);
		return ResponseEntity.ok(administrateurMisAJour);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteAdministrateur(@PathVariable Long id){
		boolean estSupprime = serviceAdministrateur.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/medecins")
	public ResponseEntity<Collection<AppUser>> findAllMedecins(){
		return ResponseEntity.ok(this.serviceAdministrateur.findAllMedecins());
	}
	
	@GetMapping("/infirmiers")
	public ResponseEntity<Collection<AppUser>> findAllInfirmiers(){
		return ResponseEntity.ok(this.serviceAdministrateur.findAllInfirmiers());
	}
	
	@GetMapping("/comptables")
	public ResponseEntity<Collection<AppUser>> findAllComptables(){
		return ResponseEntity.ok(this.serviceAdministrateur.findAllComptables());
	}
	

}
