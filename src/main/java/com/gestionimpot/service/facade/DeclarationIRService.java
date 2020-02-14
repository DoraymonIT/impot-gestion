package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationIR;

import java.util.List;

public interface DeclarationIRService {
    public List<DeclarationIR> findByEmploye(String employe);

    public  int save(DeclarationIR declarationIR);
}
