package com.gestionimpot.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity

public class DeclarationIS  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
	private String tauxDeISRef;
        @ManyToOne
	private TauxDeIS tauxDeIS;
	private String declarationTvaRef ;
	@ManyToOne
	private DeclarationTva declarationTva ;
	private  String societeRef;
	@ManyToOne
	private Societe societe;

	public String getTauxDeISRef() {
		return tauxDeISRef;
	}

	public void setTauxDeISRef(String tauxDeISRef) {
		this.tauxDeISRef = tauxDeISRef;
	}

	public String getDeclarationTvaRef() {
		return declarationTvaRef;
	}

	public void setDeclarationTvaRef(String declarationTvaRef) {
		this.declarationTvaRef = declarationTvaRef;
	}

	public String getSocieteRef() {
		return societeRef;
	}

	public void setSocieteRef(String societeRef) {
		this.societeRef = societeRef;
	}

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