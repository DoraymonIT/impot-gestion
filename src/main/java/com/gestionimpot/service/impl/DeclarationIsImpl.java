/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.service.impl;

import com.gestionimpot.bean.*;
import com.gestionimpot.dao.DeclarationIsDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.DeclarationIsService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationIsImpl implements DeclarationIsService {

    @Autowired
    DeclarationIsDao declarationISDao;
    @Autowired
    SocieteDao societeDao ;

    @Override
    public DeclarationIS findByReference(String reference) {
        return declarationISDao.findByReference(reference);
    }

    @Override
    public List<DeclarationIS> findByTauxDeIS(String tauxDeIS) {
       return declarationISDao.findAll().stream()
                .filter(taux -> tauxDeIS.equals(taux.getTauxDeIS().getRef()))
                .collect(Collectors.toList());

    }

    @Override
    public List<DeclarationIS> findByMontantTva(DeclarationTva montantTva) {
        return declarationISDao.findAll().stream()
                .filter(tva -> montantTva.equals(tva.getDeclarationTva().getTotalTva()))
                .collect(Collectors.toList());
    }

    @Override
    public Long DeleteByRef(String ref) {
        return null;
    }

    @Override
    public List<DeclarationIS> findBySocieteNom(String nom) {
        return declarationISDao.findAll().stream()
                .filter(name -> nom.equals(name.getSociete().getNom()))
                .collect(Collectors.toList());
    }

    @Override
    public int save(DeclarationIS declarationIs) {

        Societe foundedSociete=societeDao.findByRef(declarationIs.getSociete().getRef());
        if(foundedSociete==null){
            return -1;
        }
        else{
            declarationISDao.save(declarationIs);
            return 1;
        }
    }

    @Override
    public double totalGain(List<FactureGain> factureGains) {
        return  factureGains.stream().mapToDouble(Facture::getMontantTTC).sum();

    }

    @Override
    public double totalCharge(List<FactureCharge> factureCharges) {
        return  factureCharges.stream().mapToDouble(Facture::getMontantTTC).sum();
        }

    @Override
    public double beneficeNet(List<FactureCharge> factureCharges,List<FactureGain> factureGains) {
        return totalGain(factureGains)-totalCharge(factureCharges);
    }


    @Override
    public double montantPenalite(TauxDeIS tauxDeIS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DeclarationIS> findAll() {
        return declarationISDao.findAll();
    }


}
