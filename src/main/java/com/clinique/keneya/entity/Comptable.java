package com.clinique.keneya.entity;

import javax.persistence.Entity;

@Entity
public class Comptable extends AppUser {

	@Override
	public String toString() {
		return "Comptable [username=" + username + ", password=" + password + ", id=" + id + ", nom=" + nom
				+ ", prenom=" + prenom + ", salaire=" + salaire + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getRoles()=" + getRoles() + ", toString()=" + super.toString()
				+ ", getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getSalaire()="
				+ getSalaire() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	
	
	
	
	

}
