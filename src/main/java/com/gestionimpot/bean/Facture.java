package com.gestionimpot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Facture implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	protected String nomFacture;
	protected Long numeroFacture;
	@ManyToOne
	protected Societe societe;
	protected String societeRef;
	@JsonFormat(pattern="yyyy-MM-dd")
	protected Date dateFacturation; 
	@JsonFormat(pattern="yyyy-MM-dd")
	protected Date datePaiement;
	@ManyToOne
	protected DeclarationTva declarationTva;
	protected String declarationRef;
	protected   double montantHT;
	protected   double montantTTC;
	protected   double tva;

//Nombre de lignes facturées  dg
    
	public Long getId() {
		return id;
	}

	public String getDeclarationRef() {
		return declarationRef;
	}

	public void setDeclarationRef(String declarationRef) {
		this.declarationRef = declarationRef;
	}

	public String getSocieteRef() {
		return societeRef;
	}

	public void setSocieteRef(String societeRef) {
		this.societeRef = societeRef;
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

	public   double getMontantHT() {
		return montantHT;
	}

	public void setMontantHT(  double montantHT) {
		this.montantHT = montantHT;
	}

	public   double getMontantTTC() {
		return montantTTC;
	}

	public void setMontantTTC(  double montantTTC) {
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

	public   double getTva() {
		return tva;
	}

	public void setTva(  double tva) {
		this.tva = tva;
	}



}