/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.service.impl;

import com.fst.Bibleotheque.bean.Client;
import com.fst.Bibleotheque.bean.Emprunt;
import com.fst.Bibleotheque.repository.EmpruntDao;
import com.fst.Bibleotheque.service.facade.ServiceClient;
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
    @Autowired
    private ServiceClient serviceClient;
    
     @Override
    public Emprunt findByLivreTitre(String titre) {
        return empruntDao.findByLivreTitre(titre);
    }
     @Override
    public Emprunt findByClientCin(String cin) {
return empruntDao.findByClientCin(cin);}
//    public int renderss(Date dd){
//    return Calendar.getInstance(new Date());
//    }
            
    @Override
    public int save(Emprunt emprunt) {
        Client cl = serviceClient.findByCin(emprunt.getClient().getCin());
        Emprunt em = findByLivreTitre(emprunt.getLivre().getTitre());
       if(cl ==null || em ==null) return -5;
       else if(cl.getCin().equalsIgnoreCase(""))  return -1;
       else if(cl.getPointFiablite()<5) return -2;
//       else if(em.getLivre().getIsbn().equalsIgnoreCase("")) return -3;
//       else if(em.getLivre().getNbrExmplaire()==0) return -4;
            emprunt.setDateEmprunt(new Date());
            emprunt.setDateRestituerEffe(null);
            emprunt.setDateRestituerPrevu(null);
//            emprunt.setDateRestituerPrevu((new Date())+ emprunt.getLivre().getNmbrJourEmprunt());
            empruntDao.save(emprunt);
            return 1;
    }

  

    @Override
    public List<Emprunt> findByDateRestituerEffe(Date ddd) {
       return empruntDao.findByDateRestituerEffe(null);
     }

    @Override
    public List<Emprunt> findAll() {
return empruntDao.findAll();   
    }

   

   
    
}
