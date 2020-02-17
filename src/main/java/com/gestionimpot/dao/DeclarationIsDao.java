/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.dao;

import com.gestionimpot.bean.DeclarationIS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Zakaria
 */
@Repository
public interface DeclarationIsDao extends JpaRepository<DeclarationIS, Long> {
    DeclarationIS findByReference(String reference);
    DeclarationIS findBySocieteNom(String nom);
    
}
