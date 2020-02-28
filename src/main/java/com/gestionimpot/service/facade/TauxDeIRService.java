package com.gestionimpot.service.facade;

import com.gestionimpot.bean.TauxDeIR;

import java.util.Date;
import java.util.List;

public interface TauxDeIRService {
    List<TauxDeIR> findAll();

    List<TauxDeIR> findByDateDebut(Date dateDebut);
    List<TauxDeIR> findByDateFin(Date dateFin);
    List<TauxDeIR> findBySalaireMin(Double salaireMin) ;
    List<TauxDeIR> findBySalaireMax(Double salaireMax);
    List<TauxDeIR> findByPourcentage(Double pourcentage);
    TauxDeIR findByRef(String ref);
    int save(TauxDeIR tauxDeIR);
    int deleteByRef(String ref);
}
