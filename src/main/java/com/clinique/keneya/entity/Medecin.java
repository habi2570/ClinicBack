package com.clinique.keneya.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MEDECIN")
public class Medecin extends AppUser{
	private String code;	
	private Specialite specialite;
	@OneToMany
	private Collection<Diagnostic>diagnostics;
	public Medecin() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Medecin [code=" + code + ", specialite=" + specialite + ", diagnostics=" + diagnostics + ", username="
				+ username + ", password=" + password + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", salaire=" + salaire + ", getCode()=" + getCode() + ", getSpecialite()=" + getSpecialite()
				+ ", getDiagnostics()=" + getDiagnostics() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getRoles()=" + getRoles() + ", toString()=" + super.toString() + ", getId()="
				+ getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getSalaire()=" + getSalaire()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public Collection<Diagnostic> getDiagnostics() {
		return diagnostics;
	}
	public void setDiagnostics(Collection<Diagnostic> diagnostics) {
		this.diagnostics = diagnostics;
	}
	
	
	
	

}
