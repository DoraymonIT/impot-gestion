package com.gestionimpot.dao;

import com.gestionimpot.bean.DeclarationTva;
import com.gestionimpot.bean.Facture;
import com.gestionimpot.bean.Societe;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDao extends JpaRepository<Facture, Long> {

    Facture findByNumeroFacture(Long numeroFacture);

    List<Facture> findByNomFacture(String nomFacture);

    List<Facture> findByMontantHT(double montantHT);

    List<Facture> findByMontantTTC(double montantTTC);

    List<Facture> findByTva(double tva);

    List<Facture> findByDatePaiement(Date datePaiement);

    List<Facture> findByDateFacturation(Date dateFacturation);

}
