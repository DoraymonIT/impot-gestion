package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.service.facade.FactureChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/impot/FactureCharge")

public class FactureChargeRestController {
    @Autowired
    FactureChargeService factureChargeService ;
    @GetMapping("/")
    public List<FactureCharge> findAll() {
        return factureChargeService.findAll();
    }
    @GetMapping("/ref/{ref}")
    public FactureCharge findByRef(@PathVariable  String ref) {
        return factureChargeService.findByRef(ref);
    }
    @GetMapping("/fournisseur/{fournisseur}")
    public List<FactureCharge> findByFournisseur(@PathVariable  String fournisseur) {
        return factureChargeService.findByFournisseur(fournisseur);
    }
}
