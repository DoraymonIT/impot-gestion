package com.gestionimpot.bean;

import javax.persistence.*;

@Entity

public class DeclarationIS  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
        private String reference;
        
        @ManyToOne
        TauxDeIS tauxdeis;
        
        
        @ManyToOne
        DeclarationTva Montanttva;
	
	
	@ManyToOne
	private Societe societe;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
         public TauxDeIS getTauxdeis() {
        return tauxdeis;
    }

    public void setTauxdeis(TauxDeIS tauxdeis) {
        this.tauxdeis = tauxdeis;
    }
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the totalCharge
	 */
	
	
	public Societe getSociete() {
		return societe;
	}
	/**
	 * @param societe the societe to set
	 */
	public void setSociete(Societe societe) {
		this.societe = societe;
	}


}