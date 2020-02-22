
package com.gestionimpot.service.impl;

import com.gestionimpot.bean.*;
import com.gestionimpot.dao.DeclarationIsDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.DeclarationISService;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationISServiceImpl implements DeclarationISService {

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
       return declarationISDao.findAll().stream().filter(t-> tauxDeIS.equals(t.getTauxDeIS().getRef())).collect(Collectors.toList());
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
    public List<DeclarationIS> findBySocieteRef(String ref) {
         return declarationISDao.findAll().stream().filter(t-> ref.equals(t.getSociete().getRef())).collect(Collectors.toList());
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
        DeclarationIS foundedDeclarationIS = declarationISDao.findByReference(declarationIs.getReference());
        Societe foundedSociete=societeDao.findByRef(declarationIs.getSociete().getRef());
        if(foundedSociete==null)return -1;
        else if (foundedDeclarationIS != null) return -2;
        else{
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
