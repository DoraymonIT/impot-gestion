
package com.gestionimpot.service.impl;

import com.gestionimpot.bean.TauxDeIS;
import com.gestionimpot.dao.DeclarationISDao;
import com.gestionimpot.dao.TauxDeISDao;
import com.gestionimpot.service.facade.TauxDeISService;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TauxDeISServiceImpl implements TauxDeISService {

    @Autowired
    TauxDeISDao tauxDeIsDao;
    @Autowired
    DeclarationISDao declarationIsDao ;
    @Override
    public double pourcentageRetard(Date dateFacturation, Date datePaiement) {
     
        Instant instant = dateFacturation.toInstant();
        ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
        LocalDate fact = zdt.toLocalDate();

        Instant instantt = datePaiement.toInstant();
        ZonedDateTime zdtt = instantt.atZone(ZoneId.systemDefault());
        LocalDate pai = zdtt.toLocalDate();

       
        Period difference = Period.between(fact, pai);
        int months = difference.getMonths();

      if (months >= 1) {
            return 0.05 + (months - 1) * 0.01;
        } else {
            return 0;
        }
    }


    @Override
    public List<TauxDeIS> findByDateDebut(Date dateDebut) {
        return tauxDeIsDao.findByDateDebut(dateDebut);
    }

    @Override
    public List<TauxDeIS> findAll() {
        return tauxDeIsDao.findAll();
    }

    @Override
    public List<TauxDeIS> findByDateFin(Date dateFin) {
        return tauxDeIsDao.findByDateFin(dateFin);
    }

    @Override
    public List<TauxDeIS> findByMontantMin(double montantMin) {
        return tauxDeIsDao.findByMontantMin(montantMin);
    }

    @Override
    public List<TauxDeIS> findByMontantMax(double montantMax) {
        return tauxDeIsDao.findByMontantMax(montantMax);
    }

    @Override
    public TauxDeIS findByRef(String ref) {
        return tauxDeIsDao.findByRef(ref);
    }

    @Override
    public int deleteByRef(String ref) {
        TauxDeIS foundedTauxDeIS = tauxDeIsDao.findByRef(ref);
        if (foundedTauxDeIS == null)
            return -1;
        else {
            tauxDeIsDao.delete(foundedTauxDeIS);
            return 1;
        }
    }

    @Override
    public int save(TauxDeIS tauxDeIS) {
        TauxDeIS foundedTauxDeIS = tauxDeIsDao.findByRef(tauxDeIS.getRef());
        if(tauxDeIS.getTauxMax()< tauxDeIS.getTauxMin()||tauxDeIS.getTauxMoy()<tauxDeIS.getTauxMin()
                ||tauxDeIS.getTauxMoy()>tauxDeIS.getTauxMax())
            return  -2 ;
        else if (tauxDeIS.getDateDebut().compareTo(tauxDeIS.getDateFin()) > 0) 
            return -3 ;
        if (foundedTauxDeIS != null) 
            return -1;
        else { tauxDeIsDao.save(tauxDeIS);
        return 1;}
    }
   
     @Override
    public int update(TauxDeIS tauxDeIs) {
        TauxDeIS foundedTauxDeIs = tauxDeIsDao.findByRef(tauxDeIs.getRef());
        if (foundedTauxDeIs == null) 
             return -1 ;
        if(tauxDeIs.getMontantMin() != 0 && tauxDeIs.getMontantMax()!=0) {
            if(tauxDeIs.getMontantMax()< tauxDeIs.getMontantMin()) 
             return -2 ;
            foundedTauxDeIs.setMontantMin(tauxDeIs.getMontantMin());
            foundedTauxDeIs.setMontantMax(tauxDeIs.getMontantMax());
        }
        
        if(tauxDeIs.getDateDebut() != null && tauxDeIs.getDateFin()!=null) {
            if(tauxDeIs.getDateFin().getTime() < tauxDeIs.getDateDebut().getTime()||
             foundedTauxDeIs.getDateFin().getTime()< tauxDeIs.getDateDebut().getTime()
             || foundedTauxDeIs.getDateDebut().getTime()> tauxDeIs.getDateFin().getTime() )
            return -3 ;
            foundedTauxDeIs.setDateDebut(tauxDeIs.getDateDebut());
            foundedTauxDeIs.setDateFin(tauxDeIs.getDateFin());
        }
       
        if(tauxDeIs.getTauxMax()!=0 && tauxDeIs.getTauxMoy()!=0 && tauxDeIs.getTauxMin()!=0  ){
        if(tauxDeIs.getTauxMax()<tauxDeIs.getTauxMin()||tauxDeIs.getTauxMoy()<tauxDeIs.getTauxMin()
                ||tauxDeIs.getTauxMoy()>tauxDeIs.getTauxMax() ){
            return -4;
        }} else
            return -5;
        
        foundedTauxDeIs.setRef(tauxDeIs.getRef());
        foundedTauxDeIs.setTauxMin(tauxDeIs.getTauxMin());
        foundedTauxDeIs.setTauxMoy(tauxDeIs.getTauxMoy());
        foundedTauxDeIs.setTauxMax(tauxDeIs.getTauxMax());
        tauxDeIsDao.save(foundedTauxDeIs);

        return 1;
    }
    
}
