package com.gestionimpot.service.facade;

import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.bean.FactureGain;

import java.util.List;

public interface FactureChargeService {
    public  List<FactureCharge> findAll();
    public  FactureCharge findByRef(String ref );
    public  List<FactureCharge> findByFournisseurCne(String fournisseurCne);
    public  FactureCharge findByNumeroFacture(Long numeroFacture);
    public int save (FactureCharge factureCharge);
    public int deleteByRef(String ref);

}
