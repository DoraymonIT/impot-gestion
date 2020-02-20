package com.gestionimpot.service.facade;

import com.gestionimpot.bean.Client;

import java.util.List;

public interface ClientService {
    public Client findByCin(String cin);
    public  Client findByNom(String nom);
    public List<Client> findALL();
}
