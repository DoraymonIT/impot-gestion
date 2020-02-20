/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationIS;
import com.gestionimpot.bean.TauxDeIS;
import java.util.Date;
import java.util.List;


public interface TauxDeIsService {

    double pourcentageRetard(Date datefacturation,Date datepayment);
    TauxDeIS findByDeclarationIS(DeclarationIS declarationIS);
    List<TauxDeIS> findByDatedebut(Date datedebut);
    List<TauxDeIS> findAll();
    List<TauxDeIS> findByDateFin(Date dateFin);
    List<TauxDeIS> findByMontantMin( double montantMin);
    List<TauxDeIS> findByMontantMax( double montantMax);
    TauxDeIS findByRef(String ref);
    int deleteByRef(String ref);
    int save(TauxDeIS tauxDeIS);
}
