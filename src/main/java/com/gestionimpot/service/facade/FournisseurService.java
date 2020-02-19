package com.gestionimpot.service.facade;

import java.util.List;

import com.gestionimpot.bean.Fournisseur;


public interface FournisseurService {
	  public Fournisseur findByCin(String cin);
      public void save(Fournisseur fournisseur);
       public List<Fournisseur>findAll();
}
