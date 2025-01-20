package com.clinique.keneya.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinique.keneya.entity.AppUser;
import com.clinique.keneya.entity.Medecin;

public interface UserDao extends JpaRepository<AppUser, Long> {

	AppUser findByUsername(String username);

	boolean existsByUsername(String username);




}
