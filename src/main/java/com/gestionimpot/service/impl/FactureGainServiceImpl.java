package com.gestionimpot.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gestionimpot.bean.FactureGain;
import com.gestionimpot.dao.FactureGainDao;
import com.gestionimpot.service.facade.FactureGainService;

@Repository
public class FactureGainServiceImpl implements FactureGainService {
	
	private FactureGainDao factureGainDao;
	
	@Override
	public void save(FactureGain factureGain) {
		
		factureGainDao.save(factureGain);
	}
	
	@Override
	public List<FactureGain> findAll() {
		
		return factureGainDao.findAll();
	}

	@Override
	public FactureGain findByNumeroFacture(Long numeroFacture) {
		
		return factureGainDao.findByNumeroFacture(numeroFacture);
	}
	

}
