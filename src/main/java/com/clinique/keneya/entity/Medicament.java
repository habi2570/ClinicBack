package com.clinique.keneya.entity;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Medicament{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String intitule;
	protected String description;
	protected Date date;
	@Override
	public String toString() {
		return "Medicament [id=" + id + ", intitule=" + intitule + ", description=" + description + ", date=" + date
				+ "]";
	}
	
	

}
