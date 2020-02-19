package com.gestionimpot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionimpot.bean.Fournisseur;

public interface FournisseurDao extends JpaRepository<Fournisseur, Long>{
	public Fournisseur findByCin(String cin);
	public List<Fournisseur>findAll();
}
