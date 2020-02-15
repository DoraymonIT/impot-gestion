package com.gestionimpot.service.impl;

import com.gestionimpot.bean.TauxDeIR;
import com.gestionimpot.dao.TauxDeIRDao;
import com.gestionimpot.service.facade.TauxDeIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TauxDeIRServiceImpl implements TauxDeIRService {
    @Autowired
    TauxDeIRDao tauxDeIRDao ;
    @Override
    public List<TauxDeIR> findAll() {
        return tauxDeIRDao.findAll();
    }

    @Override
    public int save(TauxDeIR tauxDeIR) {

        tauxDeIRDao.save(tauxDeIR);
        return 1 ;

    }
}

