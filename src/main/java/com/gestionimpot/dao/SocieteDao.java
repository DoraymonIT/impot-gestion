package com.gestionimpot.dao;


import com.gestionimpot.bean.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocieteDao extends JpaRepository<Societe, Long> {
    public Societe findByNom(String nom);
}
