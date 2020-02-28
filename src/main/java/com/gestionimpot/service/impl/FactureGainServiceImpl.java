package com.gestionimpot.service.impl;

import java.util.List;

import com.gestionimpot.bean.Client;
import com.gestionimpot.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gestionimpot.bean.FactureGain;
import com.gestionimpot.dao.FactureGainDao;
import com.gestionimpot.service.facade.FactureGainService;

@Repository
public class FactureGainServiceImpl implements FactureGainService {
	@Autowired
	private FactureGainDao factureGainDao;
	@Autowired
	private ClientDao clientDao ;
	@Override
	public int save(FactureGain factureGain) {
		FactureGain foundedFactureGain = factureGainDao.findByNumeroFacture(factureGain.getNumeroFacture());
		Client foundedClient = clientDao.findByCin(factureGain.getClientCne());
		if (foundedFactureGain != null) return -1;
		if (foundedClient == null) return -2 ;
		else {
			factureGain.setClient(foundedClient);
			factureGainDao.save(factureGain);
			return 1;
		}
	}

	@Override
	public List<FactureGain> findAll() {
		return factureGainDao.findAll();
	}

	@Override
	public FactureGain findByNumeroFacture(Long numeroFacture) {
		return factureGainDao.findByNumeroFacture(numeroFacture);
	}

	@Override
	public List<FactureGain> findByClientCne(String clientCne) {
		return factureGainDao.findByClientCne(clientCne);
	}

	@Override
	public int deleteByRef(Long ref) {
		FactureGain foundedFactureGain = factureGainDao.findByNumeroFacture(ref);
		if (foundedFactureGain == null) return -1 ;
		else{
			factureGainDao.delete(foundedFactureGain);
			return 0;
		}
	}


}

