/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.dao;

import com.gestionimpot.bean.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Zakaria
 */
@Repository
public interface DeclarationIsDao extends JpaRepository<DeclarationIS, Long> {
    public DeclarationIS findByReference(String reference);


    public List<DeclarationIS> findAll();

    public Object save(DeclarationIS declarationIS);
    public Long DeleteByRef(String ref);
}
