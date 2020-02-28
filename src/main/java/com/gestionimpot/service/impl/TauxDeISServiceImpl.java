
package com.gestionimpot.service.impl;

import com.gestionimpot.bean.TauxDeIS;
import com.gestionimpot.dao.DeclarationISDao;
import com.gestionimpot.dao.TauxDeISDao;
import com.gestionimpot.service.facade.TauxDeISService;
import java.util.Date;
import java.util.List;
import org.joda.time.LocalDate;
import org.joda.time.Months;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TauxDeISServiceImpl implements TauxDeISService {

    @Autowired
    TauxDeISDao tauxDeIsDao;
    @Autowired
    DeclarationISDao declarationIsDao ;
    @Override
    public double pourcentageRetard(LocalDate dateFacturation, LocalDate datePaiement) {
        int months = Months.monthsBetween(datePaiement , dateFacturation ).getMonths();
        if(months >= 1 ) return  0.05 + (months-1)*0.01;
        else return 0;
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
        if (foundedTauxDeIS == null) return -1;
        else {
            tauxDeIsDao.delete(foundedTauxDeIS);
            return 1;
        }
    }

    @Override
    public int save(TauxDeIS tauxDeIS) {
        TauxDeIS foundedTauxDeIS = tauxDeIsDao.findByRef(tauxDeIS.getRef());
        if (foundedTauxDeIS != null) return -1;
        else { tauxDeIsDao.save(tauxDeIS);
        return 1;}
    }

}
