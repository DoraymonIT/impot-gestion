package com.gestionimpot.dao;

import com.gestionimpot.bean.TauxDeIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
interface TauxDeIRDao extends JpaRepository<TauxDeIR , Long> {
    List<TauxDeIR> findAll();
    List<TauxDeIR> findByDateDebut(Date dateDebut);
    List<TauxDeIR> findByDateFin(Date dateFin);
    List<TauxDeIR> findBySalaireMin(Double salaireMin) ;
    List<TauxDeIR> findBySalaireMax(Double salaireMax);
    List<TauxDeIR> findByPourcentage(Double pourcentage);
    TauxDeIR findByRef(String ref);
    Object save(TauxDeIR tauxDeIR);
    Long deleteByRef(String ref);

}
