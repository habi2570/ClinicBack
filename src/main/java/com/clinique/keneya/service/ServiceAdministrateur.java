package com.clinique.keneya.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.AdministrateurDao;
import com.clinique.keneya.dao.ComptableDao;
import com.clinique.keneya.dao.InfirmierDao;
import com.clinique.keneya.dao.MedecinDao;
import com.clinique.keneya.dao.RoleDao;
import com.clinique.keneya.dao.UserDao;
import com.clinique.keneya.entity.Administrateur;
import com.clinique.keneya.entity.AppUser;
import com.clinique.keneya.entity.Comptable;
import com.clinique.keneya.entity.Infirmier;
import com.clinique.keneya.entity.Medecin;
import com.clinique.keneya.entity.Role;
@Service
public class ServiceAdministrateur {
	@Autowired
	private AdministrateurDao administrateurDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	private UserDao userDao;
	
	public List<Administrateur> getAll() {
		return this.administrateurDao.findAll();
	}

	public Administrateur findById(Long id) {
		return null;
	}

	public Administrateur save(Administrateur administrateur) {
		
		return administrateurDao.save(administrateur);
	}

	public Administrateur update(Long id, Administrateur administrateur, Long id2) {
		return administrateurDao.save(administrateur);
	}

	public boolean delete(Long id) {
		return false;
	}

	public  Collection<AppUser> findAllMedecins() {
		// TODO Auto-generated method stub
		Role medecinRole= roleDao.findByRole("MEDECIN");
		Collection<AppUser> users= userDao.findAll();
		Collection<AppUser> medecins= new ArrayList<AppUser>();
		for(AppUser user: users) {
			if(user.getRoles().contains(medecinRole)) {
				medecins.add(user);
			}
		}
		return medecins;
	}
	
	public  Collection<AppUser> findAllInfirmiers() {
		// TODO Auto-generated method stub
		Role infirmierRole= roleDao.findByRole("INFIRMIER");
		Collection<AppUser> users= userDao.findAll();
		Collection<AppUser> infirmiers= new ArrayList<AppUser>();
		for(AppUser user: users) {
			if(user.getRoles().contains(infirmierRole)) {
				infirmiers.add(user);
			}
		}
		return infirmiers;
	}
	public  Collection<AppUser> findAllComptables() {
		// TODO Auto-generated method stub
		Role comptableRole= roleDao.findByRole("COMPTABLE");
		Collection<AppUser> users= userDao.findAll();
		Collection<AppUser> comptables= new ArrayList<AppUser>();
		for(AppUser user: users) {
			if(user.getRoles().contains(comptableRole)) {
				comptables.add(user);
			}
		}
		return comptables;
	}


}
