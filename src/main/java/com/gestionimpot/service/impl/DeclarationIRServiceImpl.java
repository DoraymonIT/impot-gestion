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
import java.util.stream.Collectors;


@Service
public class DeclarationIRServiceImpl implements DeclarationIRService {
    @Autowired
    DeclarationIRDao declarationIRDao ;
    @Autowired
    EmployeDao employeDao ;
    @Autowired
    SocieteDao societeDao ;

    @Override
    public List<DeclarationIR> findByEmploye(String employe) {
        return declarationIRDao.findAll().stream().filter(t -> employe.equals(t.getEmploye().getCin())).collect(Collectors.toList());
    }

    @Override
    public DeclarationIR findByRef(String ref) {
        return declarationIRDao.findByRef(ref);
    }

    @Override
    public List<DeclarationIR> findBySociete(String societe) {
        return declarationIRDao.findAll().stream().filter(t -> societe.equals(t.getSociete().getRef())).collect(Collectors.toList());
    }

    @Override
    public List<DeclarationIR> findBySalaire(Double salaire) {
        return declarationIRDao.findBySalaire(salaire) ;
    }

    @Override
    public List<DeclarationIR> findByMontantDeclaration(Double montantDeclaration) {
        return declarationIRDao.findByMontantDeclaration(montantDeclaration);
    }

  @Override
    public List<DeclarationIR> findByTauxDeIR(String tauxDeIR) {
        return declarationIRDao.findAll().stream().filter(t -> tauxDeIR.equals(t.getTauxDeIR().getRef())).collect(Collectors.toList());
    }

    @Override
    public List<DeclarationIR> findAll() {
        return declarationIRDao.findAll();
    }

    @Override
    public int save(DeclarationIR declarationIR) {
        DeclarationIR foundedDeclarationIR = declarationIRDao.findByRef(declarationIR.getRef());
        Employe foundedEmploye = employeDao.findByCin(declarationIR.getEmploye().getCin());
        Societe foundedSociete = societeDao.findByRef(declarationIR.getSociete().getRef());
        if(foundedEmploye == null ) return -1 ;
        else if (foundedSociete == null ) return  -2 ;
        else if (foundedDeclarationIR != null) return -3;
        else {
            declarationIRDao.save(declarationIR);
            return  1 ;
        }
    }

    @Override
    public int removeByRef(String ref) {
        DeclarationIR foundedDeclarationIR = declarationIRDao.findByRef(ref);
        if (foundedDeclarationIR == null) return -1;
        else {
            declarationIRDao.delete(foundedDeclarationIR);
            return 1;
        }
    }
}






