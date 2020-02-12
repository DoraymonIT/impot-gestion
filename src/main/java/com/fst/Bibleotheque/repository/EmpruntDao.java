/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.repository;

import com.fst.Bibleotheque.bean.Emprunt;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntDao extends JpaRepository<Emprunt, Long>{
    public List<Emprunt> findByDateRestituerEffe(Date ddd); 
}
