package com.gestionimpot.service.facade;

import com.gestionimpot.bean.TauxDeIR;

import java.util.List;

public interface TauxDeIRService {
    public List<TauxDeIR> findAll();
    public  int save(TauxDeIR tauxDeIR);
}
