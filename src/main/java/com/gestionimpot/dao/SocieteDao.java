package com.gestionimpot.dao;

import java.util.List;

import com.gestionimpot.bean.TypeSociete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionimpot.bean.Societe;

@Repository
public interface SocieteDao extends JpaRepository<Societe, Long>{
    Societe findByRef(String ref);
    List<Societe> findByNom(String nom);
    List<Societe> findByAdresse(String adresse);
    List<Societe> findByCapital(Double capital);
    List<Societe> findByNbrEmployes(Double nbrEmployes);

    List<Societe> findAll();



}