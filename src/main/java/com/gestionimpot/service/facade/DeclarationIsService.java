/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationIS;
import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.bean.FactureGain;
import com.gestionimpot.bean.TauxDeIS;
import java.util.List;

/**
 *
 * @author Zakaria
 */
public interface DeclarationIsService {
    
    public List<DeclarationIS> findBySocieteNom(String nom);

    public  int save(DeclarationIS declarationIs);
    
    public double totalGain(List<FactureGain> facturegain);
    
    public double totalCharge(List<FactureCharge> facturecharge);
    
    public double beneficeNet(List<FactureCharge> facturecharge,List<FactureGain> facturegain);
    
    public double montantPenalite(TauxDeIS tauxdeis);
    
    public List<DeclarationIS> findALL();
}
