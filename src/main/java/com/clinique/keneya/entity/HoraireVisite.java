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
public class HoraireVisite {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String horaireVisite;
	@OneToMany
	private Collection<HoraireVisite>horairevisites;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHoraireVisite() {
		return horaireVisite;
	}
	public void setHoraireVisite(String horaireVisite) {
		horaireVisite = horaireVisite;
	}
	public Collection<HoraireVisite> getHorairevisites() {
		return horairevisites;
	}
	public void setHorairevisites(Collection<HoraireVisite> horairevisites) {
		this.horairevisites = horairevisites;
	}
	@Override
	public String toString() {
		return "HoraireVisite [id=" + id + ", HoraireVisite=" + horaireVisite + ", horairevisites=" + horairevisites
				+ "]";
	}

}
