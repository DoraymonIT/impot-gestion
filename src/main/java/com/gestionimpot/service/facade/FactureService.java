
package com.gestionimpot.service.facade;

import com.gestionimpot.bean.Facture;
import com.gestionimpot.bean.Societe;
import java.util.Date;
import java.util.List;

public interface FactureService {
        Facture findByNumeroFacture(Long numeroFacture);

    List<Facture> findAll();

    List<Facture> findByTva(double tva);

    List<Facture> findByDatePaiement(Date datePaiement);

    List<Facture> findByDateFacturation(Date dateFacturation);


    int save(Facture facture);
}
