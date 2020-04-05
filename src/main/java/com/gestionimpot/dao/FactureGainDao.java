package com.gestionimpot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionimpot.bean.FactureGain;

@Repository
public interface FactureGainDao extends JpaRepository<FactureGain, Long> {
	
  FactureGain findByNumeroFacture(Long numeroFacture);
	
  public List<FactureGain> findAll();

  public List<FactureGain> findByDatePaiement(Date datePaiement);

  public List<FactureGain> findByDateFacturation(Date dateFacturation);

  public List<FactureGain> findByClientCne(String clientCne);

  public List<FactureGain> findBySocieteRef(String ref);



}
