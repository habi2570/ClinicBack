package com.clinique.keneya.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinique.keneya.entity.Medicament;

public interface MedicamentDao extends JpaRepository<Medicament, Long> {

}
