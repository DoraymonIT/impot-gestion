package com.gestionimpot.service.facade;

import com.gestionimpot.bean.Facture;
import java.util.Date;
import java.util.List;

public interface FactureService {

    Facture findByNumeroFacture(Long numeroFacture);

    List<Facture> findByNomFacture(String nomFacture);

    List<Facture> findByMontantHT(double montantHT);

    List<Facture> findByMontantTTC(double montantTTC);

    List<Facture> findByTva(double tva);

    List<Facture> findByDatePaiement(Date datePaiement);

    List<Facture> findByDateFacturation(Date dateFacturation);

    List<Facture> findAll();

}
