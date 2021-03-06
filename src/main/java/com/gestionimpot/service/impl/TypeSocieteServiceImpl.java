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
    public TypeSociete findByLibelle(String libelle) {
        return typeSocieteDao.findByLibelle(libelle);
    }

    @Override
    public List<TypeSociete> findAll() {
        return typeSocieteDao.findAll();
    }

    @Override
    public int deleteByLibelle(String libelle) {
        TypeSociete foundedTypeSociete = typeSocieteDao.findByLibelle(libelle);
        if (foundedTypeSociete == null) return -1;
        else{
            typeSocieteDao.delete(foundedTypeSociete);
            return 1;
        }

    }

    @Override
    public int save(TypeSociete typeSociete) {
        TypeSociete foundedTypeSociete = typeSocieteDao.findByLibelle(typeSociete.getLibelle());
        if (foundedTypeSociete != null) return -1;
        else  {
            typeSocieteDao.save(typeSociete);
            return 1;
        }
    }

}