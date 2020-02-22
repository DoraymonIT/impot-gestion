package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.Facture;
import com.gestionimpot.service.facade.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/impot/facture")
public class FactureRestController {
    @Autowired
    FactureService factureService ;
    @GetMapping("/numeroFacture/{numeroFacture}")
    public Facture findBynNumeroFacture(@PathVariable Long numeroFacture) {
        return factureService.findBynNumeroFacture(numeroFacture);
    }
    @GetMapping("/")
    public List<Facture> findAll() {
        return factureService.findAll();
    }
    @GetMapping("/tva/{tva}")
    public List<Facture> findByTva(@PathVariable  double tva) {
        return factureService.findByTva(tva);
    }
    @GetMapping("/datePaiement/{datePaiement}")
    public List<Facture> findByDatePaiement(@PathVariable  Date datePaiement) {
        return factureService.findByDatePaiement(datePaiement);
    }
    @GetMapping("/dateFacturation/{dateFacturation}")
    public List<Facture> findByDateFacturation(@PathVariable Date dateFacturation) {
        return factureService.findByDateFacturation(dateFacturation);
    }
}
