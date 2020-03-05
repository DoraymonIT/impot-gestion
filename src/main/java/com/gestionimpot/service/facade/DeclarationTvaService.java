package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationTva;
import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.bean.FactureGain;

import java.util.List;

public interface DeclarationTvaService {
    public DeclarationTva findByRef(String ref);
    public List<DeclarationTva> findBySocieteRef(String societeRef) ;
    public List<DeclarationTva> findByTotalTva(double totalTva);
    public List<DeclarationTva> findByAnnee(int annee);
    public List<DeclarationTva> findAll();
    public int save(DeclarationTva declarationTva , List<FactureGain> factureGains , List<FactureCharge> factureCharges);
    public int deleteByRef(String ref);
    public int update(DeclarationTva declarationTva ,  List<FactureGain> factureGains , List<FactureCharge> factureCharges);
    public int updateList(String ref , List<FactureGain> factureGains , List<FactureCharge> factureCharges);
}
