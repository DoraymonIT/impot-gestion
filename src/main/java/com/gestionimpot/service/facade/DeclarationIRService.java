package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationIR;
import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.bean.TauxDeIR;

import java.util.List;

public interface DeclarationIRService {
    public List<DeclarationIR> findByEmploye(String employe);
    public DeclarationIR findByRef(String ref);
    public List<DeclarationIR> findBySociete(String societe);
    public List<DeclarationIR> findBySalaire(Double salaire);
    public List<DeclarationIR> findByMontantDeclaration(Double montantDeclaration );
    public List<DeclarationIR> findByTauxDeIR(String tauxDeIR);
    public List<DeclarationIR> findAll();
    public int save(DeclarationIR declarationIR);
    public int update(DeclarationIR declarationIR);
    public int removeByRef(String ref);


}
