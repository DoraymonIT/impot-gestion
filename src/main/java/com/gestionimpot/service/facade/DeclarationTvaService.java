package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationTva;

import java.util.List;

public interface DeclarationTvaService {
    public List<DeclarationTva> findBySociete(String societe) ;

    public int save(DeclarationTva declarationTva);
}
