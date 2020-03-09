package com.gestionimpot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Societe> findByTypeSociete(String typeSociete) {
        return societeDao.findAll().stream().filter(nom -> typeSociete.equals(nom.getTypeSociete().getLibelle())).collect(Collectors.toList()) ;
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
    public List<Societe> findByAdresse(String adresse) {
        return societeDao.findByAdresse(adresse);
    }

    @Override
    public List<Societe> findByCapital(Double capital) {
        return societeDao.findByCapital(capital);
    }

    @Override
    public List<Societe> findByNbrEmployes(Double nbrEmployes) {
        return societeDao.findByNbrEmployes(nbrEmployes);
    }


    @Override
    public int save(Societe societe) {
       Societe foundedSociete = societeDao.findByRef(societe.getRef());
       TypeSociete foundedTypeSociete = typeSocieteDao.findByLibelle(societe.getTypeSocieteRef());
        if (foundedTypeSociete == null) {
            return -2;
        }
        if (foundedSociete != null) {
            return -1;
        }
        else {
            societe.setTypeSociete(foundedTypeSociete);
            societeDao.save(societe);
            return 1;
        }
    }

    @Override
    public int deleteByRef(String ref) {
        Societe foundedSociete = societeDao.findByRef(ref);
        if (foundedSociete == null) {
            return -1;
        }
        else {
            societeDao.delete(foundedSociete);
            return 1;
        }
    }

	@Override
	public int update(Societe societe) {
		Societe foundedSociete = societeDao.findByRef(societe.getRef());
		 if (foundedSociete==null) {
			 return -1;
		 }
		 else {
		  foundedSociete.setAdresse(societe.getAdresse());
		  foundedSociete.setCapital(societe.getCapital());
		  foundedSociete.setNbrEmployes(societe.getNbrEmployes());
		  foundedSociete.setNom(societe.getNom());
		  foundedSociete.setTypeSociete(societe.getTypeSociete());
		  societeDao.save(foundedSociete);
		  return 1;
		  
		 }
	}
}