package com.gestionimpot.service.impl;

import com.gestionimpot.bean.TauxDeIR;
import com.gestionimpot.dao.TauxDeIRDao;
import com.gestionimpot.service.facade.TauxDeIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TauxDeIRServiceImpl implements TauxDeIRService {
    @Autowired
    TauxDeIRDao tauxDeIRDao ;

    @Override
    public List<TauxDeIR> findAll() {
        return tauxDeIRDao.findAll();
    }

    @Override
    public TauxDeIR findByDeclarationIR(String declarationIR) {
        return tauxDeIRDao.findAll().stream().filter(t -> declarationIR.equals(t.getDeclarationIR().getRef())).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<TauxDeIR> findByDateDebut(Date dateDebut) {
        return tauxDeIRDao.findByDateDebut(dateDebut);
    }

    @Override
    public List<TauxDeIR> findByDateFin(Date dateFin) {
        return tauxDeIRDao.findByDateFin(dateFin);
    }

    @Override
    public List<TauxDeIR> findBySalaireMin(Double salaireMin) {
        return tauxDeIRDao.findBySalaireMin(salaireMin);
    }

    @Override
    public List<TauxDeIR> findBySalaireMax(Double salaireMax) {
        return tauxDeIRDao.findBySalaireMax(salaireMax);
    }

    @Override
    public List<TauxDeIR> findByPourcentage(Double pourcentage) {
        return tauxDeIRDao.findByPourcentage(pourcentage);
    }

    @Override
    public TauxDeIR findByRef(String ref) {
        return tauxDeIRDao.findByRef(ref);
    }

    @Override
    public int save(TauxDeIR tauxDeIR) {
        TauxDeIR foundedTauxDeIR = tauxDeIRDao.findByRef(tauxDeIR.getRef());

        if (foundedTauxDeIR != null) {
            return -1;
        }
        else{
            tauxDeIRDao.save(tauxDeIR);
            return 1;
        }
    }

    @Override
    public int deleteByRef(String ref) {
        TauxDeIR foundedTauxDeIR = tauxDeIRDao.findByRef(ref);

        if (foundedTauxDeIR == null) {
            return -1;
        }
        else{
            tauxDeIRDao.delete(foundedTauxDeIR);
            return 1;
        }
    }
}

