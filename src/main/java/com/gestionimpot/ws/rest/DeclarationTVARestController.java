package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.DeclarationTva;
import com.gestionimpot.service.facade.DeclarationTvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("impot/declarationTVA")
public class DeclarationTVARestController {
    @Autowired
    private DeclarationTvaService declarationTvaService ;

    @GetMapping("/ref/{ref}")
    public DeclarationTva findByRef(@PathVariable  String ref) {
        return declarationTvaService.findByRef(ref);
    }

    @GetMapping("/totalTva/{totalTva}")
    public List<DeclarationTva> findByTotalTva(@PathVariable  double totalTva) {
        return declarationTvaService.findByTotalTva(totalTva);
    }

    @GetMapping("/annee/{annee}")
    public List<DeclarationTva> findByAnnee(@PathVariable  int annee) {
        return declarationTvaService.findByAnnee(annee);
    }

    @GetMapping("/")
    public List<DeclarationTva> findAll() {
        return declarationTvaService.findAll();
    }

    @GetMapping("/societe/{societe}")
    public List<DeclarationTva> findBySocieteRef(@PathVariable String societeRef) {
        return declarationTvaService.findBySocieteRef(societeRef);
    }
    @PostMapping("/")
    public int save(@RequestBody DeclarationTva declarationTva) {
        return declarationTvaService.save(declarationTva , declarationTva.getFactureGains() , declarationTva.getFactureCharges());
    }
    @DeleteMapping("/delete/{ref}")
    public int DeleteByRef(@PathVariable  String ref) {
        return declarationTvaService.DeleteByRef(ref);
    }

}
