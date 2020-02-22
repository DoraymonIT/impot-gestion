package com.gestionimpot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestionimpot.bean.Fournisseur;
import com.gestionimpot.dao.FournisseurDao;
import com.gestionimpot.service.facade.FournisseurService;
import org.springframework.stereotype.Service;

@Service
public class FournisseurServiceImpl implements FournisseurService{
    @Autowired
    FournisseurDao fournisseurDao;


	@Override
	public Fournisseur findByCin(String cin) {
		return fournisseurDao.findByCin(cin);
	}

	@Override
	public List<Fournisseur> findByNom(String nom) {
		return fournisseurDao.findByNom(nom);
	}

	@Override
	public List<Fournisseur> findAll() {
		return fournisseurDao.findAll();
	}

	@Override
	public int save(Fournisseur fournisseur) {
		Fournisseur foundedFourniseur = fournisseurDao.findByCin(fournisseur.getCin());
		if (foundedFourniseur != null) return -1;
		else{
			fournisseurDao.save(fournisseur);
			return 1;
		}
	}

	@Override
	public int deleteByCin(String cin) {
		Fournisseur foundedFourniseur = fournisseurDao.findByCin(cin);
		if (foundedFourniseur == null) return -1;
		else{
			fournisseurDao.delete(foundedFourniseur);
			return 1;
		}
	}
}
