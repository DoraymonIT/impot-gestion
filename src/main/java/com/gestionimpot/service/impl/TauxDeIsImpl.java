/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.service.impl;

import com.gestionimpot.bean.TauxDeIS;
import com.gestionimpot.dao.TauxDeIsDao;
import com.gestionimpot.service.facade.TauxDeIsService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zakaria
 */
@Service
public class TauxDeIsImpl implements TauxDeIsService{

    @Autowired
    TauxDeIsDao tauxdeisdao;

    public TauxDeIS findByDatedebut(Date datedebut) {
        return tauxdeisdao.findByDatedebut(datedebut);
    }
    
    
    
    @Override
    public int save(TauxDeIS tauxdeis) {
        
        
        return 1;
    }

    @Override
    public double pourcentageRetard(Date datefacturation, Date datepayment) {
        double pourcentageretard;
        long diff = datepayment.getTime() - datefacturation.getTime();
       double res = (diff / (1000*60*60*24*30));
             if(res==1){
             pourcentageretard= 5/100;
             return pourcentageretard;

             }
             else return 0;
    }
    
}
