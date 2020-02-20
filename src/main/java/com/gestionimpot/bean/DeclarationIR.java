package com.gestionimpot.bean;

import javax.persistence.*;


@Entity
public class DeclarationIR   {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private  String ref ;
	@ManyToOne
	private Employe employe;
	@ManyToOne
	private Societe societe;
	private Double salaire;
	private Double montantDeclaration;
	@ManyToOne
	private TauxDeIR tauxDeIR;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public Double getMontantDeclaration() {
		return montantDeclaration;
	}

	public void setMontantDeclaration(Double montantDeclaration) {
		this.montantDeclaration = montantDeclaration;
	}

	public TauxDeIR getTauxDeIR() {
		return tauxDeIR;
	}

	public void setTauxDeIR(TauxDeIR tauxDeIR) {
		this.tauxDeIR = tauxDeIR;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

}