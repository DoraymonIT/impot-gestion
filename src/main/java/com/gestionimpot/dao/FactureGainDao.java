package com.gestionimpot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionimpot.bean.FactureGain;

@Repository
public interface FactureGainDao extends JpaRepository<FactureGain, Long> {
	
  FactureGain findByNumeroFacture(Long numeroFacture);
	
  List<FactureGain> findAll();

  List<FactureGain> findByDatePaiement(Date datePaiement);

  List<FactureGain> findByDateFacturation(Date dateFacturation);

  List<FactureGain> findByClientCne(String clientCne);




}
