package com.gestionimpot.service.impl;

import java.util.List;

import com.gestionimpot.bean.TypeSociete;
import com.gestionimpot.dao.TypeSocieteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.SocieteService;
@Service
public class SocieteServiceImpl implements SocieteService {
    @Autowired
    private SocieteDao societeDao;
    @Autowired
    private TypeSocieteDao typeSocieteDao ;

    @Override
    public int save(Societe societe) {
        Societe foundedSociete=findByRef(societe.getRef());
        TypeSociete foundedTypeSociete = typeSocieteDao.findByLibelle(societe.getTypeSociete().getLibelle())   ;

        if (foundedSociete != null) return -1;

        else if (foundedTypeSociete  == null ) return -2 ;


        societeDao.save(societe);

        return 1;

    }

    @Override
    public Societe findByRef(String ref) {
        return societeDao.findByRef(ref);
    }

    @Override
    public List<Societe> findByNom(String nom) {
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