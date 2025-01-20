package com.clinique.keneya.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity

public class Traitement {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String intitule;
	protected String description;
	protected Date date;
	@OneToMany
	Collection<Medicament>medicaments;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Collection<Medicament> getMedicaments() {
		return medicaments;
	}
	public void setMedicaments(ArrayList<Medicament> medicaments) {
		this.medicaments = medicaments;
	}
	@Override
	public String toString() {
		return "Traitement [id=" + id + ", intitule=" + intitule + ", description=" + description + ", date=" + date
				+ ", medicaments=" + medicaments + "]";

	}
	
	

}
