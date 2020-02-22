package com.gestionimpot.service.impl;

import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.dao.FactureChargeDao;
import com.gestionimpot.service.facade.FactureChargeService;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;
@Service
public class FactureChargeServiceImpl implements FactureChargeService {
    FactureChargeDao factureChargeDao ;
    @Override
    public List<FactureCharge> findAll() {
        return factureChargeDao.findAll();
    }

    @Override
    public FactureCharge findByRef(String ref) {
    return factureChargeDao.findByRef(ref);
    }

    @Override
    public List<FactureCharge> findByFournisseur(String fournisseur) {
        return factureChargeDao.findAll().stream().filter(f -> fournisseur.equals(f.getFournisseur().getCin())).collect(Collectors.toList());
    }

}
