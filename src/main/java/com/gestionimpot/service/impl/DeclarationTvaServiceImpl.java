package com.gestionimpot.service.impl;

import com.gestionimpot.bean.DeclarationTva;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.DeclarationTvaDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.DeclarationTvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeclarationTvaServiceImpl implements DeclarationTvaService {
    @Autowired
    DeclarationTvaDao declarationTvaDao ;
    @Autowired
    SocieteDao societeDao ;
    @Override
    public List<DeclarationTva> findBySociete(String societe) {
        return declarationTvaDao.findBySociete(societe);
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
}
