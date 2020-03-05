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
        if(tauxDeIR.getSalaireMax()< tauxDeIR.getSalaireMin()) return  -2 ;
        else if (tauxDeIR.getDateDebut().compareTo(tauxDeIR.getDateFin()) > 0)  return -3 ;
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

    @Override
    public int update(TauxDeIR tauxDeIR) {
        TauxDeIR foundedTauxDeIR = tauxDeIRDao.findByRef(tauxDeIR.getRef());
        if (foundedTauxDeIR == null) return -1 ;
        if(tauxDeIR.getSalaireMin() != 0 && tauxDeIR.getSalaireMax()!=0) {
            if(tauxDeIR.getSalaireMax()< tauxDeIR.getSalaireMin()) return -2 ;
            foundedTauxDeIR.setSalaireMax(tauxDeIR.getSalaireMax());
            foundedTauxDeIR.setSalaireMin(tauxDeIR.getSalaireMin());
        }
        if (tauxDeIR.getSalaireMin()!=0){
            if(foundedTauxDeIR.getSalaireMax()< tauxDeIR.getSalaireMin()) return -2 ;
            foundedTauxDeIR.setSalaireMin(tauxDeIR.getSalaireMin());
        }
        if (tauxDeIR.getSalaireMax()!=0){
            if(foundedTauxDeIR.getSalaireMin()> tauxDeIR.getSalaireMax()) return -2 ;
            foundedTauxDeIR.setSalaireMax(tauxDeIR.getSalaireMax());
        }
        if(tauxDeIR.getDateDebut() != null && tauxDeIR.getDateFin()!=null) {
            if(tauxDeIR.getDateFin().getTime() < tauxDeIR.getDateDebut().getTime() ) return -3 ;
            foundedTauxDeIR.setDateDebut(tauxDeIR.getDateDebut());
            foundedTauxDeIR.setDateFin(tauxDeIR.getDateFin());
        }
        if (tauxDeIR.getDateDebut() != null){
            if(foundedTauxDeIR.getDateFin().getTime()< tauxDeIR.getDateDebut().getTime()) return -3 ;
            foundedTauxDeIR.setDateDebut(tauxDeIR.getDateDebut());
        }
        if (tauxDeIR.getDateFin() != null){
            if(foundedTauxDeIR.getDateDebut().getTime()> tauxDeIR.getDateFin().getTime()) return -3 ;
            foundedTauxDeIR.setDateFin(tauxDeIR.getDateFin());
        }

        if(tauxDeIR.getPourcentage() != 0 ) foundedTauxDeIR.setPourcentage(tauxDeIR.getPourcentage());
        tauxDeIRDao.save(foundedTauxDeIR);

        return 1;
    }
}

