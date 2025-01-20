package com.clinique.keneya.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_User")
public class AppUser {
	protected String username;
	protected String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role>roles= new ArrayList<Role>();
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String nom;
	protected String prenom;
	protected Double salaire;

	
	
	
	public AppUser() {
		super();
	}
		
	public AppUser(String username, String password, Collection<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

	public AppUser(String username, String password) {
		this.username = username;
		this.password = password;
	}



	/*
	 * public User(String username, String password, Collection<Role> roles) {
	 * super(); this.username = username; this.password = password; this.roles =
	 * roles; }
	 */	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", roles=" + roles + ", id=" + id + ", nom="
				+ nom + ", prenom=" + prenom + ", salaire=" + salaire + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getRoles()=" + getRoles() + ", getId()=" + getId()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getSalaire()=" + getSalaire()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	


}
