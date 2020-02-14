/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.service.facade;

import com.fst.Bibleotheque.bean.Emprunt;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dell
 */
public interface ServiceEmprunt {
    public int save(Emprunt emprunt);
    public List<Emprunt> findByDateRestituerEffe(Date ddd); 
    public List<Emprunt> findAll();
    public Emprunt findByLivreTitre(String titre);
    public Emprunt findByClientCin(String cin);
}
