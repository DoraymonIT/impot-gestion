package com.gestionimpot.service.facade;

import java.util.List;

import com.gestionimpot.bean.TypeSociete;

public interface TypeSocieteService {
    TypeSociete findByLibelle(String libelle);
    List<TypeSociete> findAll();
    Long deleteByLibelle(String libelle);
    Object save(TypeSociete typeSociete);
}