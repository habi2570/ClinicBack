package com.clinique.keneya.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Diagnostic {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String intitule;
	private String description;
	private LocalDate date;
	@OneToMany
	private Collection<Traitement>traitements;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Collection<Traitement> getTraitements() {
		return traitements;
	}
	


	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setTraitements(Collection<Traitement> traitements) {
		this.traitements = traitements;
	}
	@Override
	public String toString() {
		return "Diagnostic [id=" + id + ", intitule=" + intitule + ", description=" + description + ", date=" 
				+ ", traitements=" + traitements + "]";
	}

}