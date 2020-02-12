/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.service.impl;

import com.fst.Bibleotheque.bean.Emprunt;
import com.fst.Bibleotheque.repository.EmpruntDao;
import com.fst.Bibleotheque.service.facade.ServiceEmprunt;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class ServiceEmpruntImpl implements ServiceEmprunt{
    @Autowired
private EmpruntDao empruntDao;
    @Override
    public int save(Emprunt emprunt) {
       if(emprunt.getClient().getCin()==null)  return -1;
       else if(emprunt.getClient().getPointFiablite()<5) return -2;
       else if(emprunt.getLivre().getIsbn()==null) return -3;
       else if(emprunt.getLivre().getNbrExmplaire()==0) return -4;
       else emprunt.setDateEmprunt(new Date());
            emprunt.setDateRestituerEffe(null);
//            emprunt.setDateRestituerPrevu(new Date()+ emprunt.getLivre().getNmbrJourEmprunt());
            empruntDao.save(emprunt);
            return 1;
    }

  

    @Override
    public List<Emprunt> findByDateRestituerEffe(Date ddd) {
return findByDateRestituerEffe(null);    }
    
}
