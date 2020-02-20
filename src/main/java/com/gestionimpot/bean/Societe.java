package com.gestionimpot.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Societe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String ref;
	private String adresse;
	private  double nbrEmployes;
	private  double capital;
	@ManyToOne
	private TypeSociete typeSociete;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public  double getNbrEmployes() {
		return nbrEmployes;
	}

	public void setNbrEmployes( double nbrEmployes) {
		this.nbrEmployes = nbrEmployes;
	}

	public  double getCapital() {
		return capital;
	}

	public void setCapital( double capital) {
		this.capital = capital;
	}

	public TypeSociete getTypeSociete() {
		return typeSociete;
	}

	public void setTypeSociete(TypeSociete typeSociete) {
		this.typeSociete = typeSociete;
	}
}