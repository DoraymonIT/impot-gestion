package com.gestionimpot.service.facade;

import com.gestionimpot.bean.*;
import java.util.Date;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeclarationISService {

    public DeclarationIS findByReference(String reference);

    public List<DeclarationIS> findByTauxDeISRef(String tauxDeIS);

    public List<DeclarationIS> findByMontantTva(double montantTva);

    public int DeleteByRef(String ref);

    public List<DeclarationIS> findBySocieteRef(String ref);

    public int save(DeclarationIS declarationIs);

    public double totalGain(String referencetva);

    public double totalCharge(String referencetva);

    public double beneficeNet(String referencetva);

    public double montantWithNoPenality(String declarationis);

    public double montantWithPenality(String declarationisref, Date facture, Date paiment);

    public double montantPenality(String declarationisref, Date facture, Date paiment);

    public List<DeclarationIS> findAll();
    
    public int update(DeclarationIS declarationIS);

    public List<DeclarationIS> findByDeclarationTvaRef(String declarationTvaRef);

}
