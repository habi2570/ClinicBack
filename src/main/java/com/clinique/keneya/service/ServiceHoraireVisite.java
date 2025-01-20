package com.clinique.keneya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.HoraireVisiteDao;
import com.clinique.keneya.entity.HoraireVisite;

@Service

public class ServiceHoraireVisite {
	@Autowired
	public HoraireVisiteDao horairevisiteDao;
	
	public List<HoraireVisite>getAll(){
		return this.horairevisiteDao.findAll();
	}
	public HoraireVisite save(HoraireVisite horairevisite) {
		return horairevisiteDao.save(horairevisite);
	}

}
