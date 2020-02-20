/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.dao;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {

    public List<Employe> findAll();

    public List<Employe> findByNom(String nom );

    public List<Employe> findByPrenom(String prenom);

    public List<Employe> findByAdresseHabit(String adresseHabit);

    public List<Employe> findByAdresseMail(String adresseMail);

    public List<Employe> findBySexe(String sexe);

    public List<Employe> findByPrime(double prime);

    public Employe findByCin(String cin);

    public List<Employe> findBySalaire(double salaire);

    public List<Employe> findBySociete(String societe);

    public  Object save(Employe employe);

    public  Long deleteByCin(String cin);

}
