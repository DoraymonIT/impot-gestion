package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationTva;

import java.util.List;

public interface DeclarationTvaService {
    public DeclarationTva findByRef(String ref);
    public List<DeclarationTva> findBySociete(String societe) ;
    public List<DeclarationTva> findByTotalTva(double totalTva);
    public List<DeclarationTva> findByAnnee(int annee);
    public List<DeclarationTva> findAll();
    public int save(DeclarationTva declarationTva);
    public int DeleteByRef(String ref);
}
