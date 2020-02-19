package com.gestionimpot.service.impl;

import com.gestionimpot.bean.DeclarationIR;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.DeclarationIRDao;
import com.gestionimpot.dao.EmployeDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.DeclarationIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarationIRServiceImpl implements DeclarationIRService {
    @Autowired
    DeclarationIRDao declarationIRDao ;
    @Autowired
    EmployeDao employeDao ;
    @Autowired
    SocieteDao societeDao ;

    @Override
    public List<DeclarationIR> findByEmploye(Employe employe) {
        return declarationIRDao.findByEmploye(employe);
    }

    @Override
    public int save(DeclarationIR declarationIR) {
        Employe foundedEmploye = employeDao.findByCin(declarationIR.getEmploye().getCin());
        Societe foundedSociete = societeDao.findByRef(declarationIR.getSociete().getRef());
        if(foundedEmploye == null ) return -1 ;
        else if (foundedSociete == null ) return  -2 ;
        else {
            declarationIRDao.save(declarationIR);

            return  1 ;

        }
    }
}






