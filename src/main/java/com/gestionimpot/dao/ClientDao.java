package com.gestionimpot.dao;

import com.gestionimpot.bean.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientDao extends JpaRepository<Client, Long> {
    public  Client findByCin(String cin);
    public  Client findByNom(String nom);
    public List<Client> findAll();
}
