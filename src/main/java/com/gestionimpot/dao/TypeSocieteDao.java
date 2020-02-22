package com.gestionimpot.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gestionimpot.bean.TypeSociete;

@Repository
public interface TypeSocieteDao extends JpaRepository<TypeSociete, Long> {

    TypeSociete findByLibelle(String libelle);
    List<TypeSociete> findAll();


}