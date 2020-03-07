package com.gestionimpot.service.impl;

import com.gestionimpot.bean.Facture;
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
    public Facture findByNumeroFacture(Long numeroFacture) {
        return factureDao.findByNumeroFacture(numeroFacture);
    }

    @Override
    public List<Facture> findByNomFacture(String nomFacture) {
        return factureDao.findByNomFacture(nomFacture);
    }

    @Override
    public List<Facture> findByMontantHT(double montantHT) {
        return factureDao.findByMontantHT(montantHT);
    }

    @Override
    public List<Facture> findByMontantTTC(double montantTTC) {
        return factureDao.findByMontantTTC(montantTTC);
    }

    @Override
    public List<Facture> findByTva(double tva) {
        return factureDao.findByTva(tva);
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
    public List<Facture> findAll() {
        return factureDao.findAll();
    }

}
