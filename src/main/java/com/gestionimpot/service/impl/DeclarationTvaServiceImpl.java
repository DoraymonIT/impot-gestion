package com.gestionimpot.service.impl;

import com.gestionimpot.bean.DeclarationTva;
import com.gestionimpot.dao.DeclarationTvaDao;
import com.gestionimpot.service.facade.DeclarationTvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeclarationTvaServiceImpl implements DeclarationTvaService {
@Autowired
DeclarationTvaDao declarationTvaDao ;
    @Override
    public List<DeclarationTva> findBySociete(String societe) {
        return declarationTvaDao.findBySociete(societe);
    }

    @Override
    public int save(DeclarationTva declarationTva) {
        try {

            declarationTvaDao.save(declarationTva);
            return 1;
        }
        catch (Exception e){return -1;}
    }
}
