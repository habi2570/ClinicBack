package com.clinique.keneya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.ComptableDao;
import com.clinique.keneya.entity.Comptable;
@Service
public class ServiceComptable {
	@Autowired
	public ComptableDao comptableDao;

	public List<Comptable> getAll() {
		return this.comptableDao.findAll();
	}

	public Comptable findById(Long id) {
		return null;
	}

	public Comptable save(Comptable comptable) {
		return comptableDao.save(comptable);
	}

	public Comptable update(Long id, Comptable comptable, Long id2) {
		return comptableDao.save(comptable) ;
	}

}
