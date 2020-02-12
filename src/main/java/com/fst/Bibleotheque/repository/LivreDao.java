/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.repository;

import com.fst.Bibleotheque.bean.Livre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface LivreDao extends JpaRepository<Livre, Long>{
    public List<Livre> findByIsbn(String isbn);
    
}
