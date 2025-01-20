package com.clinique.keneya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.MedicamentDao;
import com.clinique.keneya.entity.Medicament;

@Service

public class ServiceMedicament {
	@Autowired
	public MedicamentDao medicamentDao;

	public List<Medicament> getAll() {
		return this.medicamentDao.findAll();
	}

	public Medicament findById(Long id) {
		return null;
	}

	public Medicament save(Medicament medicament) {
		return medicamentDao.save(medicament);
	}

	public Medicament update(Long id, Medicament medicament, Long id2) {
		return null;
	}

	public boolean delete(Long id) {
		return false;
	}

}
