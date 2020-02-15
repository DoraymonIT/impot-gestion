package com.gestionimpot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.SocieteService;
@Service
public class SocieteServiceImpl implements SocieteService {
    @Autowired
    private SocieteDao societeDao;


    @Override
    public int save(Societe societe) {
        Societe findSociete=findByNom(societe.getNom());
        if (findSociete != null) {
            return -1;
        }
        societeDao.save(societe);

        return 1;



    }



    @Override
    public Societe findByNom(String nom) {
        return societeDao.findByNom(nom);
    }

    @Override
    public List<Societe> findAll() {
        return societeDao.findAll();
    }

    @Override
    public List<Societe> findByTypeSocieteLibelle(String libelle) {
        return societeDao.findByTypeSocieteLibelle(libelle);
    }

    @Override
    public List<Societe> findByAdresse(String adresse) {
        return societeDao.findByAdresse(adresse);
    }

    @Override
    public List<Societe> findByCapital(Double capital) {
        return	societeDao.findByCapital(capital);
    }

    @Override
    public List<Societe> findByNbrEmployes(Double nbrEmployes) {
        return societeDao.findByNbrEmployes(nbrEmployes);
    }

}