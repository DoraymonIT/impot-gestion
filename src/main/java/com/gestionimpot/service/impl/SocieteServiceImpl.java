package com.gestionimpot.service.impl;

import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocieteServiceImpl implements SocieteService {
@Autowired
    SocieteDao societeDao ;
    @Override
    public Societe findByNom(String nom) {
        return societeDao.findByNom(nom);
    }
}
