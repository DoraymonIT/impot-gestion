package com.gestionimpot.service.impl;

import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.bean.FactureGain;
import com.gestionimpot.bean.Fournisseur;
import com.gestionimpot.dao.FactureChargeDao;
import com.gestionimpot.dao.FournisseurDao;
import com.gestionimpot.service.facade.FactureChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;
@Service
public class FactureChargeServiceImpl implements FactureChargeService {
    @Autowired
    FactureChargeDao factureChargeDao ;
    @Autowired
    FournisseurDao fournisseurDao ;
    @Override
    public List<FactureCharge> findAll() {
        return factureChargeDao.findAll();
    }

    @Override
    public FactureCharge findByRef(String ref) {
    return factureChargeDao.findByRef(ref);
    }

    @Override
    public List<FactureCharge> findByFournisseurCne(String fournisseur) {
    return factureChargeDao.findByFournisseurCne(fournisseur);
    }

    @Override
    public int save(FactureCharge factureCharge) {
        FactureCharge foundedFactureCharge = factureChargeDao.findByRef(factureCharge.getRef());
        Fournisseur foundedFournisseur = fournisseurDao.findByCin(factureCharge.getFournisseurCne());
        if (foundedFournisseur == null) return -1 ;
        else if (foundedFactureCharge != null) return -2 ;
        else{
          factureCharge.setFournisseur(foundedFournisseur);
          factureChargeDao.save(factureCharge);
          return 1;
        }



    }

    @Override
    public int deleteByRef(String ref) {
        FactureCharge foundedFactureCharge = factureChargeDao.findByRef(ref);
        if (foundedFactureCharge == null) return -1;
        else {
            factureChargeDao.delete(foundedFactureCharge);
            return 1;
        }
    }

    @Override
    public FactureCharge findByNumeroFacture(Long numeroFacture) {
        return factureChargeDao.findByNumeroFacture(numeroFacture);
    }
}
