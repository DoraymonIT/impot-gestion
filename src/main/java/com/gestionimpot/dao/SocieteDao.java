package com.gestionimpot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionimpot.bean.Societe;

@Repository
public interface SocieteDao extends JpaRepository<Societe, Long>{
    public Societe findByNom(String nom);
    public List<Societe> findByAdresse(String adresse);
    public List<Societe> findByCapital(Double capital);
    public List<Societe> findByNbrEmployes(Double nbrEmployes);
    public List<Societe> findByTypeSocieteLibelle(String libelle);
}