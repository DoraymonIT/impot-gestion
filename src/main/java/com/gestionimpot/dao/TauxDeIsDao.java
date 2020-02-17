/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.dao;

import com.gestionimpot.bean.TauxDeIS;
import java.util.Date;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zakaria
 */
@Repository
public interface TauxDeIsDao {
    
    TauxDeIS findByDatedebut(Date datedebut);
    
}
