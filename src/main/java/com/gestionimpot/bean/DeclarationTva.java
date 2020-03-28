package com.gestionimpot.bean;

import java.util.List;

import javax.persistence.*;

@Entity
public class DeclarationTva {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Double totalTva;
	private String ref ;
	private String societeRef ;
	@ManyToOne
	private Societe societe;
	private int annee;
        @OneToMany
	private List<FactureGain> factureGains;
    	@OneToMany
	private List<FactureCharge> factureCharges;

	public Double getTotalTva() {
		return totalTva;
	}

	public void setTotalTva(Double totalTva) {
		this.totalTva = totalTva;
	}

	public String getSocieteRef() {

		return societeRef;
	}

	public void setSocieteRef(String societeRef) {
		this.societeRef = societeRef;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public List<FactureGain> getFactureGains() {
		return factureGains;
	}

	public void setFactureGains(List<FactureGain> factureGains) {
		this.factureGains = factureGains;
	}

	public List<FactureCharge> getFactureCharges() {
		return factureCharges;
	}

	public void setFactureCharges(List<FactureCharge> factureCharges) {
		this.factureCharges = factureCharges;
	}
}