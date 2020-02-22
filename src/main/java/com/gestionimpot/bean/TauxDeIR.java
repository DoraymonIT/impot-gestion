package com.gestionimpot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

import javax.persistence.*;

@Entity
public class TauxDeIR {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String ref ;
	@ManyToOne
	private DeclarationIR declarationIR;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateDebut;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateFin;
	private  double salaireMin;
	private  double salaireMax;
	private  double pourcentage;

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
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

	public  double getSalaireMin() {
		return salaireMin;
	}

	public void setSalaireMin( double salaireMin) {
		this.salaireMin = salaireMin;
	}

	public  double getSalaireMax() {
		return salaireMax;
	}

	public void setSalaireMax( double salaireMax) {
		this.salaireMax = salaireMax;
	}

	public  double getPourcentage() {
		return pourcentage;
	}

	public void setPourcentage( double pourcentage) {
		this.pourcentage = pourcentage;
	}

	public DeclarationIR getDeclarationIR() {
		return declarationIR;
	}

	public void setDeclarationIR(DeclarationIR declarationIR) {
		this.declarationIR = declarationIR;
	}
}