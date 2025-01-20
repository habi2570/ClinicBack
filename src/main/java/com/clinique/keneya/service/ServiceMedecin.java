package com.clinique.keneya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.MedecinDao;
import com.clinique.keneya.entity.Medecin;

@Service

public class ServiceMedecin {
	@Autowired
	public MedecinDao medecinDao;


	public List<Medecin> getAll() {
		return this.medecinDao.findAll();
	}

	public Medecin findById(Long id) {
		return null;
	}

	public Medecin save(Medecin medecin) {
		System.out.println(medecin);
		return medecinDao.save(medecin);
	}

	public Medecin update(Long id, Medecin medecin, Long id2) {
		return null;
	}
 
	public boolean delete(Long id) {
		return false;
	}

}
