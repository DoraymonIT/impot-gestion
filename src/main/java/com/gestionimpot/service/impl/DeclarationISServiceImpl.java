package com.gestionimpot.service.impl;

import com.gestionimpot.bean.*;
import com.gestionimpot.dao.DeclarationISDao;
import com.gestionimpot.dao.DeclarationTvaDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.dao.TauxDeISDao;
import com.gestionimpot.service.facade.DeclarationISService;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeclarationISServiceImpl implements DeclarationISService {

    @Autowired
    DeclarationISDao declarationISDao;
    @Autowired
    SocieteDao societeDao;
    @Autowired
    TauxDeISDao tauxDeISDao;
    @Autowired
    DeclarationTvaDao declarationTvaDao;

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
        return declarationISDao.findAll().stream().filter(m -> montantTva == m.getDeclarationTva().getTotalTva()).collect(Collectors.toList());
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
    public double totalGain(String referencetva) {
        List<FactureGain> foundedfacturegain = declarationTvaDao.findByRef(referencetva).getFactureGains(); 
        return foundedfacturegain.stream().mapToDouble(Facture::getMontantTTC).sum();
    }

    @Override
    public double totalCharge(String referencetva) {
        List<FactureCharge> foundedfacturecharge = declarationTvaDao.findByRef(referencetva).getFactureCharges();
        return foundedfacturecharge.stream().mapToDouble(Facture::getMontantTTC).sum();
    }

    @Override
    public double beneficeNet(String referencetva) {
        return (totalGain(referencetva) - totalCharge(referencetva));
    }
    
    @Override
    public double montantWithNoPenality(String declarationisref) {
    
        String referencetaux = tauxDeISDao.findByRef(declarationISDao.findByReference(declarationisref).getTauxDeIS().getRef()).getRef();
        String referencetva = declarationTvaDao.findByRef(declarationISDao.findByReference(declarationisref).getDeclarationTva().getRef()).getRef();
        double montant = DeclarationISServiceImpl.this.beneficeNet(referencetva);
    
        TauxDeIS foundedTis = tauxDeISDao.findByRef(referencetaux);
        if (montant <= foundedTis.getMontantMin()) {
            return montant * foundedTis.getTauxMin();
        } else if (montant > foundedTis.getMontantMin() && montant <= foundedTis.getMontantMax()) {
            return montant * foundedTis.getTauxMoy();
        } else {
            return montant * foundedTis.getTauxMax();
        }
    }

    @Override
    public double montantPenality(String declarationisref, Date facture, Date paiment) {
        TauxDeISServiceImpl t = new TauxDeISServiceImpl();
        double pourcentagePenalite = t.pourcentageRetard(facture, paiment);
        double montantApayerHP = montantWithNoPenality(declarationisref);

        return pourcentagePenalite * montantApayerHP;
    }

    @Override
    public double montantWithPenality(String declarationisref, Date facture, Date paiment) {
        double mp = montantPenality(declarationisref, facture, paiment);
        double mwnp = montantWithNoPenality(declarationisref);
        if (mp == 0) {
            return mwnp;
        } else {
            return mwnp + mp;
        }
    }

    @Override
    public int save(DeclarationIS declarationIs) {
        DeclarationTva foundedDeclarationTva = declarationTvaDao.findByRef(declarationIs.getDeclarationTvaRef());
        TauxDeIS foundedTauxDeIS = tauxDeISDao.findByRef(declarationIs.getTauxDeISRef());
        DeclarationIS foundedDeclarationIS = declarationISDao.findByReference(declarationIs.getReference());
        Societe foundedSociete = societeDao.findByRef(declarationIs.getSocieteRef());
        if (foundedSociete == null) {
            return -1;
        } else if (foundedDeclarationIS != null) {
            return -2;
        } else if (foundedTauxDeIS == null) {
            return -3;
        } else if (foundedDeclarationTva == null) {
            return -4;
        } else {
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
        if (foundedDeclarationIS == null) {
            return -1;
        } else {
            declarationISDao.delete(foundedDeclarationIS);
            return 1;
        }
    }

    @Override
    public int update(DeclarationIS declarationIS) {
        DeclarationIS foundedDeclarationIS = declarationISDao.findByReference(declarationIS.getReference());
        if (foundedDeclarationIS == null) {
            return -5;
        }
        TauxDeIS foundedTauxDeIS = foundedDeclarationIS.getTauxDeIS();
        DeclarationTva foundedDeclarationTva = foundedDeclarationIS.getDeclarationTva();
        Societe foundedSociete = foundedDeclarationIS.getSociete();
        if (declarationIS.getTauxDeIS() != null) {
            foundedTauxDeIS = tauxDeISDao.findByRef(declarationIS.getTauxDeISRef());
            foundedDeclarationIS.setTauxDeISRef(declarationIS.getTauxDeISRef());
            if (foundedTauxDeIS == null) {
                return -6;
            }
        }
        if (declarationIS.getSocieteRef() != null) {
            foundedSociete = societeDao.findByRef(declarationIS.getSocieteRef());
            foundedDeclarationIS.setSocieteRef(declarationIS.getSocieteRef());
            if (foundedSociete == null) {
                return -7;
            }
        }
        if (declarationIS.getDeclarationTvaRef() != null) {
            foundedDeclarationTva = declarationTvaDao.findByRef(declarationIS.getDeclarationTvaRef());
            foundedDeclarationIS.setDeclarationTvaRef(declarationIS.getDeclarationTvaRef());
            if (foundedDeclarationTva == null) {
                return -8;
            }
        }
        foundedDeclarationIS.setReference(declarationIS.getReference());
        foundedDeclarationIS.setDeclarationTva(foundedDeclarationTva);
        foundedDeclarationIS.setSociete(foundedSociete);
        foundedDeclarationIS.setTauxDeIS(foundedTauxDeIS);
        declarationISDao.save(foundedDeclarationIS);
        return 1;
    }

}
