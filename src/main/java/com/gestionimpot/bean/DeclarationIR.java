package com.gestionimpot.bean;

import javax.persistence.*;


@Entity
public class DeclarationIR   {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private  String ref ;
	private String emplyeRef ;
	@ManyToOne
	private Employe employe;
	private String societeRef ;
	@ManyToOne
	private Societe societe;
	private Double salaire;
	private Double montantDeclaration;
	private String tauxDeIrRef ;
	@ManyToOne
	private TauxDeIR tauxDeIR;

	public Long getId() {
		return id;
	}

	public String getEmplyeRef() {
		return emplyeRef;
	}

	public void setEmplyeRef(String emplyeRef) {
		this.emplyeRef = emplyeRef;
	}

	public String getSocieteRef() {
		return societeRef;
	}

	public void setSocieteRef(String societeRef) {
		this.societeRef = societeRef;
	}

	public String getTauxDeIrRef() {
		return tauxDeIrRef;
	}

	public void setTauxDeIrRef(String tauxDeIrRef) {
		this.tauxDeIrRef = tauxDeIrRef;
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