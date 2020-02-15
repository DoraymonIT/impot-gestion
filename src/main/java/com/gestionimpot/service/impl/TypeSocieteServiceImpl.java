package com.gestionimpot.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionimpot.bean.TypeSociete;
import com.gestionimpot.dao.TypeSocieteDao;
import com.gestionimpot.service.facade.TypeSocieteService;
@Service
public class TypeSocieteServiceImpl implements TypeSocieteService{
    @Autowired
    private TypeSocieteDao typeSocieteDao;
    @Override
    public int save(TypeSociete typeSociete) {
        typeSocieteDao.save(typeSociete);
        return 1;
    }
    @Override
    public List<TypeSociete> findByLibelle(String libelle) {
        return typeSocieteDao.findByLibelle(libelle);
    }
}