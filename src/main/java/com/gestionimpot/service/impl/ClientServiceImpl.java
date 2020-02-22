package com.gestionimpot.service.impl;

import com.gestionimpot.bean.Client;
import com.gestionimpot.dao.ClientDao;
import com.gestionimpot.service.facade.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao ;
    @Override
    public Client findByCin(String cin) {
        return clientDao.findByCin(cin);
    }

    @Override
    public Client findByNom(String nom) {
        return
                clientDao.findByNom(nom);
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }
}
