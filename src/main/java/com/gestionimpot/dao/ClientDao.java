package com.gestionimpot.dao;

import com.gestionimpot.bean.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {
    public  Client findByCin();
}
