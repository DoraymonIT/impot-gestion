/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.dao;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {

    Employe findBynNumeroEmploye(Long numeroEmploye);

    List<Employe> findAll();

    Employe findByCin(String cin);
//

    List<Employe> findBySalaire(double salaire);

    List<Employe> findBysocieteNom(Societe societe);

}
