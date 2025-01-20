package com.clinique.keneya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.TraitementDao;
import com.clinique.keneya.entity.Traitement;

@Service

public class ServiceTraitement {
	@Autowired
	public TraitementDao traitementDao;

	public List<Traitement> getAll() {
		return this.traitementDao.findAll();
	}

	public Traitement findById(Long id) {
		return null;
	}

	public Traitement update(Long id, Traitement traitement, Long id2) {
		return traitementDao.save(traitement);
	}

	public Traitement save(Traitement traitement) {
		return traitementDao.save(traitement);
	}

	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
