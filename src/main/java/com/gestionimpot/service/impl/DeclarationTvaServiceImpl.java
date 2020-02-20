package com.gestionimpot.service.impl;

import com.gestionimpot.bean.DeclarationTva;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.DeclarationTvaDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.DeclarationTvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeclarationTvaServiceImpl implements DeclarationTvaService {
    @Autowired
    DeclarationTvaDao declarationTvaDao ;
    @Autowired
    SocieteDao societeDao ;

    @Override
    public DeclarationTva findByRef(String ref) {
        return declarationTvaDao.findByRef(ref);
    }

    @Override
    public List<DeclarationTva> findBySociete(String societe) {
        return declarationTvaDao.findAll().stream()
                .filter(name -> societe.equals(name.getSociete().getNom()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DeclarationTva> findByTotalTva(Double totalTva) {
        return declarationTvaDao.findByTotalTva(totalTva);
    }

    @Override
    public List<DeclarationTva> findByAnnee(int annee) {
        return declarationTvaDao.findByAnnee(annee);
    }

    @Override
    public List<DeclarationTva> findAll() {
        return declarationTvaDao.findAll();
    }

    @Override
    public int save(DeclarationTva declarationTva) {
        Societe foundedSociete = societeDao.findByRef(declarationTva.getSociete().getRef()) ;
        if (foundedSociete == null ) return  -1 ;
        else {

            declarationTvaDao.save(declarationTva);
            return 1;
        }
    }

    @Override
    public int DeleteByRef(String ref) {
        DeclarationTva foundedDeclarationTva = declarationTvaDao.findByRef(ref) ;
        if (foundedDeclarationTva == null ) return  -1 ;
        else {

            declarationTvaDao.delete(foundedDeclarationTva);
            return 1;
        }
    }
}
