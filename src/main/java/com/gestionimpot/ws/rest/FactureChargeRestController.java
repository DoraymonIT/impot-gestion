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

    @GetMapping("/fournisseurCne/{fournisseurCne}")
    public List<FactureCharge> findByFournisseurCne(@PathVariable  String fournisseurCne) {
        return factureChargeService.findByFournisseurCne(fournisseurCne);
    }
    @PostMapping("/")
    public int save(@RequestBody  FactureCharge factureCharge) {
        return factureChargeService.save(factureCharge);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable  String ref) {
        return factureChargeService.deleteByRef(ref);
    }
}
