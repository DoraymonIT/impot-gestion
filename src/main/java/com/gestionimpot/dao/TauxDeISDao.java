
package com.gestionimpot.dao;


import  com.gestionimpot.bean.TauxDeIS;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public  interface TauxDeISDao extends JpaRepository<TauxDeIS , Long> {

    List<TauxDeIS> findByDateDebut(Date dateDebut);
    List<TauxDeIS> findAll();
    List<TauxDeIS> findByDateFin(Date dateFin);
    List<TauxDeIS> findByMontantMin( double montantMin);
    List<TauxDeIS> findByMontantMax( double montantMax);
    TauxDeIS findByRef(String ref);

}
