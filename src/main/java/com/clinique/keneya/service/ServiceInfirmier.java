package com.clinique.keneya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.InfirmierDao;
import com.clinique.keneya.entity.Infirmier;

@Service

public class ServiceInfirmier {
	@Autowired
	public InfirmierDao infirmierDao;

	public List<Infirmier> getAll() {
		return this.infirmierDao.findAll();
	}

	public Infirmier findById(Long id) {
		return null;
	}

	public Infirmier save(Infirmier infirmier) {
		return infirmierDao.save(infirmier);
	}

	public Infirmier update(Long id, Infirmier infirmier, Long id2) {
		
		return infirmierDao.save(infirmier);
	}

	public boolean delete(Long id) {
		return false;
	}

}
