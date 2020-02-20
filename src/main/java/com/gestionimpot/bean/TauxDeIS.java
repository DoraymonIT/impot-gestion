package com.gestionimpot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TauxDeIS {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref ;
	@ManyToOne
	private DeclarationIS declarationIS;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateDebut;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateFin;
	private  double montantMin;
	private  double montantMax;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public DeclarationIS getDeclarationIS() {
		return declarationIS;
	}

	public void setDeclarationIS(DeclarationIS declarationIS) {
		this.declarationIS = declarationIS;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public  double getMontantMin() {
		return montantMin;
	}

	public void setMontantMin( double montantMin) {
		this.montantMin = montantMin;
	}

	public  double getMontantMax() {
		return montantMax;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMontantMax( double montantMax) {
		this.montantMax = montantMax;
	}

}