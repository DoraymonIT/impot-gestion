package com.gestionimpot.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Facture implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
        protected String nomFacture;
        protected Long numeroFacture;
	@ManyToOne
	protected Societe societe;
	protected Date dateFacturation;
	protected Date datePaiement;
	@ManyToOne
	protected DeclarationTva declarationTva;
	protected Double montantHT;
	protected Double montantTTC;
	protected Double tva;

//Nombre de lignes facturées

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

    public String getNomFacture() {
        return nomFacture;
    }

    public void setNomFacture(String nomFacture) {
        this.nomFacture = nomFacture;
    }

    public Long getNumeroFacture() {
        return numeroFacture;
    }

    public void setNumeroFacture(Long numeroFacture) {
        this.numeroFacture = numeroFacture;
    }

    public Double getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(Double montantHT) {
        this.montantHT = montantHT;
    }

    public Double getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(Double montantTTC) {
        this.montantTTC = montantTTC;
    }
	
	public Societe getSociete() {
		return societe;
	}
	
	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public Date getDateFacturation() {
		return dateFacturation;
	}

	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	
	public DeclarationTva getDeclarationTva() {
		return declarationTva;
	}

	public void setDeclarationTva(DeclarationTva declarationTva) {
		this.declarationTva = declarationTva;
	}
	
	public Double getTva() {
		return tva;
	}
	
	public void setTva(Double tva) {
		this.tva = tva;
	}



}