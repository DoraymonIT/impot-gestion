/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionimpot.dao;

import com.gestionimpot.bean.Facture;
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
public interface FactureDao extends JpaRepository<Facture, Long> {

    Facture findBynNumeroFacture(Long numeroFacture);

    List<Facture> findAll();

    List<Facture> finfByTva(double tva);

    List<Facture> findByDatePaiement(Date datePaiement);

    List<Facture> findByDateFacturation(Date dateFacturation);
    

}
