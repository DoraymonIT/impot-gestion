/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.service.impl;

import com.fst.Bibleotheque.bean.Client;
import com.fst.Bibleotheque.repository.ClientDao;
import com.fst.Bibleotheque.service.facade.ServiceClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dell
 */
@Service
public class ServiceClientImpl implements ServiceClient{

    @Autowired
    private ClientDao clientdao;
    @Override
    public Client findByCne(String cne) {
        return clientdao.findByCne(cne);
    }

    @Override
    public List<Client> findBypointFiabliteLessthan(int x) {
        return clientdao.findBypointFiabliteLessthan(x);
    }

    @Override
    public List<Client> trouver5PointFiablites() {
        if(findBypointFiabliteLessthan(5)!=null) {
            return findBypointFiabliteLessthan(5);
            
        }
        else return null;
        }
    
}
