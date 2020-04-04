package com.gestionimpot.service.facade;

import java.util.List;

import com.gestionimpot.bean.Fournisseur;

public interface FournisseurService {
	public Fournisseur findByCin(String cin);

	public List<Fournisseur> findByNom(String nom);

	public List<Fournisseur> findAll();

	public int save(Fournisseur fournisseur);

	public int deleteByCin(String cin);

	public int update(Fournisseur fournisseur);
}
