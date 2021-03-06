package com.gestionimpot.service.impl;

import com.gestionimpot.bean.DeclarationTva;
import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.bean.FactureGain;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.DeclarationTvaDao;
import com.gestionimpot.dao.FactureChargeDao;
import com.gestionimpot.dao.FactureGainDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.DeclarationTvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeclarationTvaServiceImpl implements DeclarationTvaService {
    @Autowired
    DeclarationTvaDao declarationTvaDao ;
    @Autowired
    SocieteDao societeDao ;
    @Autowired
    FactureChargeDao factureChargeDao ;
    @Autowired
    FactureGainDao factureGainDao ;
    @Override
    public DeclarationTva findByRef(String ref) {
        return declarationTvaDao.findByRef(ref);
    }

    @Override
    public List<DeclarationTva> findBySocieteRef(String societeRef) {
    return declarationTvaDao.findBySocieteRef(societeRef);
    }

    @Override
    public List<DeclarationTva> findByTotalTva(double totalTva) {
        return declarationTvaDao.findByTotalTva(totalTva);
    }

    @Override
    public List<DeclarationTva> findByAnnee(int annee) {
        return declarationTvaDao.findByAnnee(annee);
    }

    @Override
    public List<DeclarationTva> findAll() {
        return declarationTvaDao.findAll();
    }

    @Override
    public int save(DeclarationTva declarationTva , List<FactureGain> factureGains , List<FactureCharge> factureCharges) {
        List<FactureCharge> factureCharges1 = new ArrayList<>();
        List<FactureGain> factureGains1 = new ArrayList<>() ;
        DeclarationTva foundedDeclarationTva = declarationTvaDao.findByRef(declarationTva.getRef());
        Societe foundedSociete = societeDao.findByRef(declarationTva.getSocieteRef()) ;
        for (FactureGain g :factureGains) {
            FactureGain foundedFactureGain = factureGainDao.findByNumeroFacture(g.getNumeroFacture()) ;
            if(foundedFactureGain == null ) return -3 ;
            factureGains1.add(foundedFactureGain);
        }
        for (FactureCharge g :factureCharges) {
            FactureCharge foundedFactureCharge = factureChargeDao.findByNumeroFacture(g.getNumeroFacture()) ;
            if(foundedFactureCharge == null ) return -4 ;
            factureCharges1.add(foundedFactureCharge);
        }
        if (foundedSociete == null ) return  -1 ;
        if (foundedDeclarationTva != null) return -2 ;
        else {
            declarationTva.setFactureGains(factureGains1);
            declarationTva.setFactureCharges(factureCharges1);
            declarationTva.setSociete(foundedSociete);
            declarationTvaDao.save(declarationTva);
            return 1;
        }
    }

    @Override
    public int deleteByRef(String ref) {
        DeclarationTva foundedDeclarationTva = declarationTvaDao.findByRef(ref) ;
        if (foundedDeclarationTva == null ) return  -1 ;
        else {
            declarationTvaDao.delete(foundedDeclarationTva);
            return 1;
        }
    }

    @Override
    public int update(DeclarationTva declarationTva ,  List<FactureGain> factureGains , List<FactureCharge> factureCharges) {
        DeclarationTva foundedDeclarationTva = declarationTvaDao.findByRef(declarationTva.getRef());
        if (foundedDeclarationTva == null) return -1 ;
        List<FactureCharge> factureCharges1 = foundedDeclarationTva.getFactureCharges();
        List<FactureGain> factureGains1 = foundedDeclarationTva.getFactureGains() ;
        Societe foundedSociete = foundedDeclarationTva.getSociete();
        int foundedAnnee = foundedDeclarationTva.getAnnee();
        double foundedTotalTva = foundedDeclarationTva.getTotalTva();
        if(declarationTva.getSocieteRef()!= null) {
            foundedSociete = societeDao.findByRef(declarationTva.getSocieteRef()) ;
            if (foundedSociete == null) return -2 ;
            foundedDeclarationTva.setSocieteRef(declarationTva.getSocieteRef());
        }
        if(factureGains != null) {
            for (FactureGain g : factureGains) {
                FactureGain foundedFactureGain = factureGainDao.findByNumeroFacture(g.getNumeroFacture());
                if (foundedFactureGain == null) return -3;
                factureGains1.add(foundedFactureGain);
            }
        }
        if (factureCharges != null){
            for (FactureCharge g :factureCharges) {
                FactureCharge foundedFactureCharge = factureChargeDao.findByNumeroFacture(g.getNumeroFacture()) ;
                if(foundedFactureCharge == null ) return -4 ;
                factureCharges1.add(foundedFactureCharge);
            }
        }
        if (declarationTva.getAnnee() != 0 ) {
            foundedAnnee = declarationTva.getAnnee();
        }
        if (declarationTva.getTotalTva() != 0 ) {
            foundedTotalTva = declarationTva.getTotalTva();
        }
        foundedDeclarationTva.setAnnee(foundedAnnee);
        foundedDeclarationTva.setTotalTva(foundedTotalTva);
        foundedDeclarationTva.setSociete(foundedSociete);
        foundedDeclarationTva.setFactureGains(factureGains1);
        foundedDeclarationTva.setFactureCharges(factureCharges1);
        declarationTvaDao.save(foundedDeclarationTva);
        return 1;
    }

    @Override
    public int updateList(String ref, List<FactureGain> factureGains, List<FactureCharge> factureCharges) {
        DeclarationTva foundedDeclarationTva = declarationTvaDao.findByRef(ref);
        if (foundedDeclarationTva == null) return -1 ;
        if(factureGains != null) {
            List<FactureGain> factureGains1 = new ArrayList<>() ;
            for (FactureGain g : factureGains) {
                FactureGain foundedFactureGain = factureGainDao.findByNumeroFacture(g.getNumeroFacture());
                if (foundedFactureGain == null) return -3;
                factureGains1.add(foundedFactureGain);
            }
            foundedDeclarationTva.setFactureGains(factureGains1);
        }
        if (factureCharges != null){
            List<FactureCharge> factureCharges1 = new ArrayList<>() ;
            for (FactureCharge g :factureCharges) {
                FactureCharge foundedFactureCharge = factureChargeDao.findByNumeroFacture(g.getNumeroFacture()) ;
                if(foundedFactureCharge == null ) return -3 ;
                factureCharges1.add(foundedFactureCharge);
            }
            foundedDeclarationTva.setFactureCharges(factureCharges1);
        }
        declarationTvaDao.save(foundedDeclarationTva);
        return 1; 
    }

    @Override
    public DeclarationTva findBysocieteRef(String societeref) {
    return declarationTvaDao.findBysocieteRef(societeref);
    }
}
