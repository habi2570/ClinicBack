package com.clinique.keneya.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clinique.keneya.entity.Diagnostic;

public interface DiagnosticDao extends JpaRepository<Diagnostic, Long> {

}
