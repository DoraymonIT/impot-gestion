package com.gestionimpot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionimpot.bean.TypeSociete;
@Repository
public interface TypeSocieteDao extends JpaRepository<TypeSociete, Long> {
    public List<TypeSociete> findByLibelle(String libelle);

}