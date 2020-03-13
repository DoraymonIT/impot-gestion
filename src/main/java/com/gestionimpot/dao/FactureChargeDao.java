package com.gestionimpot.dao;

import com.gestionimpot.bean.FactureCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FactureChargeDao extends JpaRepository<FactureCharge, Long> {

	public List<FactureCharge> findByFournisseurCin(String fournisseurCin);

	public FactureCharge findByNumeroFacture(Long numeroFacture);

	public List<FactureCharge> findAll();

	public FactureCharge findByRef(String ref);	

	public List<FactureCharge> findByMontantHT(double montantHT);

	public List<FactureCharge> findByMontantTTC(double montantTTC);

	public List<FactureCharge> findByTva(double tva);

	public List<FactureCharge> findByDatePaiement(Date datePaiement);

	public List<FactureCharge> findByDateFacturation(Date dateFacturation);
	
	public List<FactureCharge> findBySocieteRef(String ref );
}
