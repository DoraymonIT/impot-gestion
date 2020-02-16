package com.gestionimpot.service.impl;

import com.gestionimpot.bean.Facture;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.FactureDao;
import com.gestionimpot.service.facade.FactureService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FactureServiceImpl implements FactureService {

    @Autowired
    private FactureDao factureDao;

    @Override
    public Facture findBynNumeroFacture(Long numeroFacture) {
        return factureDao.findBynNumeroFacture(numeroFacture);
    }

    @Override
    public List<Facture> findAll() {
        return factureDao.findAll();
    }

    @Override
    public List<Facture> finfByTva(double tva) {
        return factureDao.finfByTva(tva);
    }

    @Override
    public List<Facture> findByDatePaiement(Date datePaiement) {
        return factureDao.findByDatePaiement(datePaiement);
    }

    @Override
    public List<Facture> findByDateFacturation(Date dateFacturation) {
        return factureDao.findByDateFacturation(dateFacturation);
    }

    @Override
    public int save(Facture facture) {
        // Apres je veux faire les conditions if selon besoin 
        return 1;
    }

}
