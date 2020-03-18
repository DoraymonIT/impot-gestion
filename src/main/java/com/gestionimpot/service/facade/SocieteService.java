package com.gestionimpot.service.facade;

import java.util.List;


import com.gestionimpot.bean.Societe;


public interface SocieteService {
    List<Societe> findByTypeSociete(String typeSociete);
    int deleteByRef(String ref);
    public int update(Societe societe);
    int save(Societe societe) ;
    Societe findByRef(String ref);
    List<Societe> findByNom(String nom);
    List<Societe> findAll();
    List<Societe> findByAdresse(String adresse);
    List<Societe> findByCapital(Double capital);
    List<Societe> findByNbrEmployes(Double nbrEmployes);
    

}