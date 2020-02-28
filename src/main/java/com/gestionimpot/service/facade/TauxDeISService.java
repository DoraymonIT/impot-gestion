package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationIS;
import com.gestionimpot.bean.TauxDeIS;

import org.joda.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface TauxDeISService {

    double pourcentageRetard(LocalDate dateFacturation, LocalDate datePaiement) ;
    List<TauxDeIS> findByDateDebut(Date dateDebut);
    List<TauxDeIS> findAll();
    List<TauxDeIS> findByDateFin(Date dateFin);
    List<TauxDeIS> findByMontantMin( double montantMin);
    List<TauxDeIS> findByMontantMax( double montantMax);
    TauxDeIS findByRef(String ref);
    int deleteByRef(String ref);
    int save(TauxDeIS tauxDeIS);
}
