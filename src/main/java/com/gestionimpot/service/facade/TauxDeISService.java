package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationIS;
import com.gestionimpot.bean.TauxDeIS;

import java.util.Date;
import java.util.List;


public interface TauxDeISService {

    double pourcentageRetard(Date dateFacturation, Date datePaiement) ;
    List<TauxDeIS> findByDateDebut(Date dateDebut);
    List<TauxDeIS> findAll();
    List<TauxDeIS> findByDateFin(Date dateFin);
    List<TauxDeIS> findByMontantMin( double montantMin);
    List<TauxDeIS> findByMontantMax( double montantMax);
    TauxDeIS findByRef(String ref);
    public int update(TauxDeIS tauxdeis);
    int deleteByRef(String ref);
    int save(TauxDeIS tauxDeIS);
}
