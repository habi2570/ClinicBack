package com.clinique.keneya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinique.keneya.entity.HoraireVisite;
import com.clinique.keneya.service.ServiceHoraireVisite;

@RestController
@RequestMapping("/HoraireVisite")

public class HoraireVisiteController {
	@Autowired
	private ServiceHoraireVisite serviceHoraireVisite;
	@GetMapping("/all")
	private List<HoraireVisite> getArrayList(){
		return this.serviceHoraireVisite.getAll();	
	}

/*
 * @GetMapping("/{id}") public
 * ResponseEntity<HoraireVisite>getHoraireVisiteById(@PathVariable Long id){
 * HoraireVisite horairevisite = serviceHoraireVisite.findById(id); }
 */
}