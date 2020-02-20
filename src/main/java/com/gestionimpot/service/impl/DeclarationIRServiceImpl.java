package com.gestionimpot.service.impl;

import com.gestionimpot.bean.DeclarationIR;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.bean.TauxDeIR;
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
    public DeclarationIR findByRef(String ref) {
        return null;
    }

    @Override
    public List<DeclarationIR> findBySociete(Societe societe) {
        return null;
    }

    @Override
    public List<DeclarationIR> findBySalaire(Double salaire) {
        return null;
    }

    @Override
    public List<DeclarationIR> findByMontantDeclaration(Double montantDeclaration) {
        return null;
    }

    @Override
    public List<DeclarationIR> findByTauxDeIR(TauxDeIR tauxDeIR) {
        return null;
    }

    @Override
    public List<DeclarationIR> findByAll() {
        return null;
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

    @Override
    public int removeByRef(String ref) {
        return 0;
    }
}






