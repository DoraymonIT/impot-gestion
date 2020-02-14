package com.gestionimpot.dao;

import com.gestionimpot.bean.TauxDeIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TauxDeIRDao extends JpaRepository<TauxDeIR , Long> {
public List<TauxDeIR> findAll(); 
}
