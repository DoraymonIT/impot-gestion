package com.gestionimpot.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class TauxDeIS {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    
    private double TauxMin;
    private double TauxMoy;
    private double TauxMax;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;
    private double montantMin;
    private double montantMax;

    public void setTauxMin(double TauxMin) {
        this.TauxMin = TauxMin;
    }

    public void setTauxMoy(double TauxMoy) {
        this.TauxMoy = TauxMoy;
    }

    public void setTauxMax(double TauxMax) {
        this.TauxMax = TauxMax;
    }

    public double getTauxMin() {
        return TauxMin;
    }

    public double getTauxMoy() {
        return TauxMoy;
    }

    public double getTauxMax() {
        return TauxMax;
    }

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

    public double getMontantMin() {
        return montantMin;
    }

    public void setMontantMin(double montantMin) {
        this.montantMin = montantMin;
    }

    public double getMontantMax() {
        return montantMax;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMontantMax(double montantMax) {
        this.montantMax = montantMax;
    }

}
