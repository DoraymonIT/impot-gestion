package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.DeclarationIS;
import com.gestionimpot.service.facade.DeclarationISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("impot/declarationIS")
public class DeclarationISRestController {
    @Autowired
    private DeclarationISService declarationISService ;
    @GetMapping("/reference/{reference}")
    public DeclarationIS findByReference(@PathVariable String reference) {
        return declarationISService.findByReference(reference);
    }

    @GetMapping("/tauxDeIS/{tauxDeIS}")
    public List<DeclarationIS> findByTauxDeIS(@PathVariable String tauxDeIS) {
        return declarationISService.findByTauxDeIS(tauxDeIS);
    }

    @GetMapping("/montantTva/{montantTva}")
    public List<DeclarationIS> findByMontantTva(@PathVariable  double montantTva) {
        return declarationISService.findByMontantTva(montantTva);
    }


    @GetMapping("/societe/{ref}")
    public List<DeclarationIS> findBySocieteRef(@PathVariable  String ref) {
        return declarationISService.findBySocieteRef(ref);
    }
    @PostMapping("/")
    public int save(@RequestBody  DeclarationIS declarationIs) {
        return declarationISService.save(declarationIs);
    }
    @GetMapping("/")
    public List<DeclarationIS> findAll() {
        return declarationISService.findAll();
    }
    @DeleteMapping("/DeleteByRef/{ref}")
    public int DeleteByRef(@PathVariable  String ref) {
        return declarationISService.DeleteByRef(ref);
    }

}
