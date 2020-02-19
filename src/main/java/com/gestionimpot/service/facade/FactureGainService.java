package com.gestionimpot.service.facade;

import java.util.List;

import com.gestionimpot.bean.FactureGain;

public interface FactureGainService {
	
	public void save(FactureGain factureGain);
	
	public List<FactureGain> findAll();
	
	public FactureGain findByNumeroFacture(Long numeroFacture);
	
	

}
