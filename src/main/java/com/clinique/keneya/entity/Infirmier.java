package com.clinique.keneya.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "INFIRMIER")
public class Infirmier extends AppUser {

	@Override
	public String toString() {
		return "Infirmier [username=" + username + ", password=" + password + ", id=" + id + ", nom=" + nom
				+ ", prenom=" + prenom + ", salaire=" + salaire + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getRoles()=" + getRoles() + ", toString()=" + super.toString()
				+ ", getId()=" + getId() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getSalaire()="
				+ getSalaire() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
	

}
