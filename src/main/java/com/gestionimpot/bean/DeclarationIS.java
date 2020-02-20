package com.gestionimpot.bean;

import javax.persistence.*;

@Entity

public class DeclarationIS  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	@ManyToOne
	private TauxDeIS tauxDeIS;
	@ManyToOne
	private DeclarationTva declarationTva ;
	@ManyToOne
	private Societe societe;

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public TauxDeIS getTauxDeIS() {
		return tauxDeIS;
	}

	public void setTauxDeIS(TauxDeIS tauxDeIS) {
		this.tauxDeIS = tauxDeIS;
	}

	public DeclarationTva getDeclarationTva() {
		return declarationTva;
	}

	public void setDeclarationTva(DeclarationTva declarationTva) {
		this.declarationTva = declarationTva;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}
}