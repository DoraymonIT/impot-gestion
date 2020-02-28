
package com.gestionimpot.service.impl;

import com.gestionimpot.bean.*;
import com.gestionimpot.dao.DeclarationISDao;
import com.gestionimpot.dao.DeclarationTvaDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.dao.TauxDeISDao;
import com.gestionimpot.service.facade.DeclarationISService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationISServiceImpl implements DeclarationISService {

    @Autowired
    DeclarationISDao declarationISDao;
    @Autowired
    SocieteDao societeDao ;
    @Autowired
    TauxDeISDao tauxDeISDao ;
    @Autowired
    DeclarationTvaDao declarationTvaDao ;

    @Override
    public DeclarationIS findByReference(String reference) {
        return declarationISDao.findByReference(reference);
    }

    @Override
    public List<DeclarationIS> findByTauxDeISRef(String tauxDeIS) {
        return declarationISDao.findByTauxDeISRef(tauxDeIS);
    }


    @Override
    public List<DeclarationIS> findByMontantTva(double montantTva) {
        return declarationISDao.findAll().stream().filter(m->montantTva == m.getDeclarationTva().getTotalTva()).collect(Collectors.toList());
    }

    @Override
    public List<DeclarationIS> findAll() {
        return declarationISDao.findAll();
    }

    @Override
    public List<DeclarationIS> findByDeclarationTvaRef(String declarationTvaRef) {
        return declarationISDao.findByDeclarationTvaRef(declarationTvaRef);
    }

    @Override
    public List<DeclarationIS> findBySocieteRef(String ref) {
        return declarationISDao.findBySocieteRef(ref);
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
        return 0;
    }

    @Override
    public int save(DeclarationIS declarationIs) {
        DeclarationTva foundedDeclarationTva = declarationTvaDao.findByRef(declarationIs.getDeclarationTvaRef());
        TauxDeIS foundedTauxDeIS = tauxDeISDao.findByRef(declarationIs.getTauxDeISRef());
        DeclarationIS foundedDeclarationIS = declarationISDao.findByReference(declarationIs.getReference());
        Societe foundedSociete=societeDao.findByRef(declarationIs.getSocieteRef());
        if(foundedSociete==null)return -1;
        else if (foundedDeclarationIS != null) return -2;
        else if (foundedTauxDeIS == null) return -3 ;
        else if (foundedDeclarationTva == null) return -4 ;
        else{
            declarationIs.setDeclarationTva(foundedDeclarationTva);
            declarationIs.setSociete(foundedSociete);
            declarationIs.setTauxDeIS(foundedTauxDeIS);
            declarationISDao.save(declarationIs);
            return 1;
        }
    }

    @Override
    public int DeleteByRef(String ref) {
        DeclarationIS foundedDeclarationIS = declarationISDao.findByReference(ref);
        if (foundedDeclarationIS == null) return -1;
        else{
            declarationISDao.delete(foundedDeclarationIS);
            return 1;
        }
    }



}
