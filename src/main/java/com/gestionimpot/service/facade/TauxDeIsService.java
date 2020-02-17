/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.service.facade;

import com.gestionimpot.bean.TauxDeIS;
import java.util.Date;

/**
 *
 * @author Zakaria
 */
public interface TauxDeIsService {
    public int save(TauxDeIS tauxdeis ); 
    public double pourcentageRetard(Date datefacturation,Date datepayment);
    
}
