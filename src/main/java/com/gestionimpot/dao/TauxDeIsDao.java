/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.dao;

import com.gestionimpot.bean.DeclarationIS;
import  com.gestionimpot.bean.TauxDeIS;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
interface TauxDeIsDao extends JpaRepository<TauxDeIS , Long> {
    TauxDeIS findByDeclarationIS(String declarationIS);
    List<TauxDeIS> findByDatedebut(Date datedebut);
    List<TauxDeIS> findAll();
    List<TauxDeIS> findByDateFin(Date dateFin);
    List<TauxDeIS> findByMontantMin( double montantMin);
    List<TauxDeIS> findByMontantMax( double montantMax);
    TauxDeIS findByRef(String ref);
    Long deleteByRef(String ref);
    Object save(TauxDeIS tauxDeIS);
}
