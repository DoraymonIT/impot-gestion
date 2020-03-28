package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.DeclarationIR;
import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.bean.TauxDeIR;
import com.gestionimpot.service.facade.DeclarationIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("impot/declarationIR")
public class DeclarationIRRestController {
    @Autowired
    private DeclarationIRService declarationIRService ;

    @GetMapping("/reference/{ref}")
    public DeclarationIR findByRef(@PathVariable String ref) {
        return declarationIRService.findByRef(ref);
    }
    @GetMapping("/employe/{employe}")
    public List<DeclarationIR> findByEmploye(@PathVariable String employe) {
        return declarationIRService.findByEmploye(employe);
    }
    @GetMapping("/societe/{societe}")
    public List<DeclarationIR> findBySociete(@PathVariable  String societe) {
        return declarationIRService.findBySociete(societe);
    }

    @GetMapping("/tauxDeIR/{tauxDeIR}")
    public List<DeclarationIR> findByTauxDeIR(@PathVariable  String tauxDeIR) {
        return declarationIRService.findByTauxDeIR(tauxDeIR);
    }
    @GetMapping("/salaire/{salaire}")
    public List<DeclarationIR> findBySalaire(@PathVariable  Double salaire) {
        return declarationIRService.findBySalaire(salaire);
    }
    @GetMapping("/montantDeclaration/{montantDeclaration}")
    public List<DeclarationIR> findByMontantDeclaration(@PathVariable  Double montantDeclaration) {
        return declarationIRService.findByMontantDeclaration(montantDeclaration);
    }
    @GetMapping("/")
    public List<DeclarationIR> findAll() {
        return declarationIRService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody  DeclarationIR declarationIR) {
        return declarationIRService.save(declarationIR);
    }
    @DeleteMapping("/ref/{ref}")
    public int removeByRef(@PathVariable  String ref) {
        return declarationIRService.removeByRef(ref);
    }
    @PostMapping("/update/")
    public int update(@RequestBody  DeclarationIR declarationIR) {
        return declarationIRService.update(declarationIR);
    }
}

