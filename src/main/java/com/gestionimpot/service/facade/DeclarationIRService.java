package com.gestionimpot.service.facade;

import com.gestionimpot.bean.DeclarationIR;
import com.gestionimpot.bean.Employe;

import java.util.List;

public interface DeclarationIRService {
    public List<DeclarationIR> findByEmploye(Employe employe);

    public  int save(DeclarationIR declarationIR);
  //  public Long removeByRef(String ref);

}
