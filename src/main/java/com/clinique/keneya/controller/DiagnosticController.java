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

import com.clinique.keneya.entity.Diagnostic;
import com.clinique.keneya.service.ServiceDiagnostic;

@RestController
@RequestMapping("/Diagnostic")
public class DiagnosticController {
	@Autowired
	private ServiceDiagnostic serviceDiagnostic;
	@GetMapping("/all")
	private List<Diagnostic>getArrayList(){
		return this.serviceDiagnostic.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Diagnostic>getDiagnosticById(@PathVariable Long id){
		Diagnostic diagnostic = serviceDiagnostic.findById(id);
		return ResponseEntity.ok(diagnostic);
	}
	@PostMapping("/nouveau")
	public ResponseEntity<Diagnostic>createDiagnostic(@RequestParam Long id,@RequestBody Diagnostic diagnostic){ 
		Diagnostic nouveauDiagnostic = serviceDiagnostic.save(diagnostic,id);
		return new ResponseEntity<>(nouveauDiagnostic,HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Diagnostic>updateDiagnostic(@PathVariable Long id,@RequestBody Diagnostic diagnostic){
		Diagnostic diagnosticMisAJour = serviceDiagnostic.update(id, diagnostic,id);
		return ResponseEntity.ok(diagnosticMisAJour);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>deleteDiagnostic(@PathVariable Long id){
		return ResponseEntity.noContent().build();
	}

}
