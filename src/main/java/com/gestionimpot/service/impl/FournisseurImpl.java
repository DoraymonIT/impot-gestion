package com.gestionimpot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gestionimpot.bean.Fournisseur;
import com.gestionimpot.dao.FournisseurDao;
import com.gestionimpot.service.facade.FournisseurService;

public class FournisseurImpl implements FournisseurService{
    @Autowired
    FournisseurDao fournisseurDao;
	@Override
	public Fournisseur findByCin(String cin) {
		return fournisseurDao.findByCin(cin);
	}			

	@Override
	public void save(Fournisseur fournisseur) {
		fournisseurDao.save(fournisseur);
					
	}

	@Override
	public List<Fournisseur> findAll() {
		return fournisseurDao.findAll();
	}
	

}
