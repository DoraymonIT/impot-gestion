package com.gestionimpot.service.facade;

import java.util.List;

import com.gestionimpot.bean.TypeSociete;

public interface TypeSocieteService {
    public int save(TypeSociete typeSociete);
    public List<TypeSociete> findByLibelle(String libelle);
}