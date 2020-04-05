package com.gestionimpot.service.facade;

import com.gestionimpot.bean.FactureCharge;

import java.util.Date;
import java.util.List;

public interface FactureChargeService {
	public List<FactureCharge> findByFournisseurCin(String fournisseurCin);

	public FactureCharge findByNumeroFacture(Long numeroFacture);

	public List<FactureCharge> findAll();

	public FactureCharge findByRef(String ref);

	public List<FactureCharge> findByMontantHT(double montantHT);

	public List<FactureCharge> findByMontantTTC(double montantTTC);

	public List<FactureCharge> findByTva(double tva);

	public List<FactureCharge> findByDatePaiement(Date datePaiement);

	public List<FactureCharge> findByDateFacturation(Date dateFacturation);

	public int save(FactureCharge factureCharge);

	public int deleteByRef(String ref);
	
	public int update(FactureCharge factureCharge);
	
	public List<FactureCharge> findBySocieteRef(String ref);


}
