package com.gestionimpot.service.facade;

import java.util.List;

import com.gestionimpot.bean.Societe;

public interface SocieteService {
    public int save(Societe societe) ;
    public Societe findByRef(String ref);
    public List<Societe> findByNom(String nom);
    public List<Societe> findAll();
    public List<Societe> findByAdresse(String adresse);
    public List<Societe> findByCapital(Double capital);
    public List<Societe> findByNbrEmployes(Double nbrEmployes);
    public List<Societe> findByTypeSocieteLibelle(String libelle);
}