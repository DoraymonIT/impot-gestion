package com.gestionimpot.service.impl;

import com.gestionimpot.bean.DeclarationIR;
import com.gestionimpot.dao.DeclarationIRDao;
import com.gestionimpot.service.facade.DeclarationIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationIRServiceImpl implements DeclarationIRService {
    @Autowired
    DeclarationIRDao declarationIRDao ;
    @Override
    public List<DeclarationIR> findByEmploye(String employe) {
        return declarationIRDao.findByEmploye(employe);
    }

    @Override
    public int save(DeclarationIR declarationIR) {
        try {

            declarationIRDao.save(declarationIR);
            return 1;

        }
        catch (Exception e){return -1 ; }
    }
}






