package com.gestionimpot.service.facade;

import java.util.List;

import com.gestionimpot.bean.FactureGain;

public interface FactureGainService {
	
	public int save(FactureGain factureGain);
	
	public List<FactureGain> findAll();
	
	public FactureGain findByNumeroFacture(Long numeroFacture);

	public List<FactureGain> findByClientCne(String clientCne);

	public int deleteByRef(Long ref);
        
        public List<FactureGain> findBySocieteRef(String ref );


}
