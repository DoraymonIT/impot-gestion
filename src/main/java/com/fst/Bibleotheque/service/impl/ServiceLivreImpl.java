/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.service.impl;

import com.fst.Bibleotheque.bean.Livre;
import com.fst.Bibleotheque.repository.LivreDao;
import com.fst.Bibleotheque.service.facade.ServiceLivre;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author dell
 */
public class ServiceLivreImpl implements ServiceLivre{
@Autowired
private LivreDao livreDao;
    @Override
    public List <Livre> findByIsbN(String isbn) {
return livreDao.findByIsbn(isbn);   }
    
}
