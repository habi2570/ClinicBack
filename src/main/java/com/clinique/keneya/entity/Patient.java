package com.clinique.keneya.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tel;
	private String nom;
	private String prenom;
	private Date date;
	private Float poids;
	private Sexe sexe;
	private Groupsanguin groupsanguin;

	@OneToMany
	private Collection<Diagnostic> diagnostics = new ArrayList<Diagnostic>();

	public Patient() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaiss() {
		return date;
	}

	public void setDateNaiss(Date dateNaiss) {
		this.date = dateNaiss;
	}

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Groupsanguin getGroupsanguin() {
		return groupsanguin;
	}

	public void setGroupsanguin(Groupsanguin groupsanguin) {
		this.groupsanguin = groupsanguin;
	}

	public Collection<Diagnostic> getDiagnostics() {
		return diagnostics;
	}

	public void setDiagnostics(ArrayList<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", num_Telephone=" + tel + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaiss=" + date + ", poids=" + poids + ", sexe=" + sexe + ", groupsanguin=" + groupsanguin
				+ ", diagnostics=" + diagnostics + "]";
	}

}
