package com.clinique.keneya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinique.keneya.dao.UserDao;
import com.clinique.keneya.entity.AppUser;

@Service

public class ServiceUser {
	@Autowired
	public UserDao userDao;

	public List<AppUser> getAll() {
		return this.userDao.findAll();
	}

	public AppUser findById(Long id) {
		return null;
	}

	public AppUser save(AppUser user) {
		return userDao.save(user);
	}

	public AppUser update(Long id, AppUser user, Long id2) {
		return userDao.save(user);
	}

	public void delete(Long id) {
		userDao.deleteById(id);;
	}

}
