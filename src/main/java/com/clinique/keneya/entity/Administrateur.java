package com.clinique.keneya.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ADMINISTRATEUR")
public class Administrateur extends AppUser{
	
	

	public Administrateur() {
		
	}
	




	@Override
	public String toString() {
		return "Administrateur [" + username + ", password=" + password + ", id="
				+ id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + ", getEmployes()="
				+  ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ ", getRoles()=" + getRoles() + ", toString()=" + super.toString() + ", getId()=" + getId()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getSalaire()=" + getSalaire()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}





}
