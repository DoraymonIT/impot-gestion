package com.gestionimpot.service.facade;

import com.gestionimpot.bean.FactureCharge;

import java.util.List;

public interface FactureChargeService {
    public  List<FactureCharge> findAll();
    public  FactureCharge findByRef(String ref );
    public  List<FactureCharge> findByFournisseur(String fournisseur);


}
