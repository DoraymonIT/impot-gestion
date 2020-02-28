
package com.gestionimpot.service.facade;

import com.gestionimpot.bean.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeclarationISService {
    public DeclarationIS findByReference(String reference);
    public List<DeclarationIS> findByTauxDeISRef(String tauxDeIS);
    public List<DeclarationIS> findByMontantTva(double montantTva);
    public int DeleteByRef(String ref);
    public List<DeclarationIS> findBySocieteRef(String ref);
    public int save(DeclarationIS declarationIs);
    public double totalGain(List<FactureGain> facturegain);
    public double totalCharge(List<FactureCharge> facturecharge);
    public double beneficeNet(List<FactureCharge> facturecharge,List<FactureGain> facturegain);
    public double montantPenalite(TauxDeIS tauxdeis);
    public List<DeclarationIS> findAll();
    public List<DeclarationIS> findByDeclarationTvaRef(String declarationTvaRef );

}
