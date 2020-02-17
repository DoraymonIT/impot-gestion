/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.service.impl;

import com.gestionimpot.bean.DeclarationIS;
import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.bean.FactureGain;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.bean.TauxDeIS;
import com.gestionimpot.dao.DeclarationIsDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.DeclarationIsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zakaria
 */
@Service
public class DeclarationIsImpl implements DeclarationIsService {

  @Autowired
  DeclarationIsDao declarationisdao;
  @Autowired
  SocieteDao societeDao ;
  
    @Override
    public int save(DeclarationIS declarationIs) {
        
        Societe foundedsociete=societeDao.findByRef(declarationIs.getSociete().getRef());
     if(foundedsociete==null){
       return -1;
        }
        else{
        declarationisdao.save(declarationIs);
        return 1;
        }
    }

    @Override
    public double totalGain(List<FactureGain> facturegain) {
      double totalgain=0;
        List<FactureGain> FactureGain = facturegain;
        for (int i = 0; i < FactureGain.size(); i++) {
            FactureGain get = FactureGain.get(i);
           totalgain+= get.getMontantTTC();
            
        }
        
        return totalgain;
        
        
    }

    @Override
    public double totalCharge(List<FactureCharge> facturecharge) {
        double totalcharge=0;
        List<FactureCharge> FactureCharge = facturecharge;
        for (int i = 0; i < FactureCharge.size(); i++) {
            FactureCharge get = FactureCharge.get(i);
           totalcharge+= get.getMontantTTC();
            
        }
        
        return totalcharge;
        
        }

    @Override
    public double beneficeNet(List<FactureCharge> facturecharge,List<FactureGain> facturegain) {
        return totalGain(facturegain)-totalCharge(facturecharge);
        
    }

    @Override
    public List<DeclarationIS> findBySocieteNom(String nom) {
        return (List<DeclarationIS>) declarationisdao.findBySocieteNom(nom);
        
    }

    @Override
    public double montantPenalite(TauxDeIS tauxdeis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DeclarationIS> findALL() {
    return declarationisdao.findAll();
    }
    
    
    
}
