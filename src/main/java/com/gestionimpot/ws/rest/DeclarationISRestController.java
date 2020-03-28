package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.DeclarationIS;
import com.gestionimpot.service.facade.DeclarationISService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("impot/declarationIS")
public class DeclarationISRestController {

    @Autowired
    private DeclarationISService declarationISService;

    @GetMapping("/reference/{reference}")
    public DeclarationIS findByReference(@PathVariable String reference) {
        return declarationISService.findByReference(reference);
    }

    @GetMapping("/tauxDeIS/{tauxDeISref}")
    public List<DeclarationIS> findByTauxDeISRef(@PathVariable String tauxDeISref) {
        return declarationISService.findByTauxDeISRef(tauxDeISref);
    }

    @GetMapping("/montantTva/{montantTva}")
    public List<DeclarationIS> findByMontantTva(@PathVariable double montantTva) {
        return declarationISService.findByMontantTva(montantTva);
    }

    @GetMapping("/societe/{ref}")
    public List<DeclarationIS> findBySocieteRef(@PathVariable String ref) {
        return declarationISService.findBySocieteRef(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody DeclarationIS declarationIs) {
        return declarationISService.save(declarationIs);
    }

    @GetMapping("/")
    public List<DeclarationIS> findAll() {
        return declarationISService.findAll();
    }

    @DeleteMapping("/DeleteByRef/{ref}")
    public int DeleteByRef(@PathVariable String ref) {
        return declarationISService.DeleteByRef(ref);
    }

    @GetMapping("/totalgain/{referencetva}")
    public double totalGain(@PathVariable String referencetva) {
        return declarationISService.totalGain(referencetva);
    }

    @GetMapping("/totalcharge/{referencetva}")
    public double totalCharge(@PathVariable String referencetva) {
        return declarationISService.totalCharge(referencetva);
    }

    @GetMapping("/beneficenet/{referencetva}")
    public double beneficeNet(@PathVariable String referencetva) {
        return declarationISService.beneficeNet(referencetva);
    }

    @GetMapping("/montantWithNoPenality/{declarationisref}")
    public double montantWithNoPenality(@PathVariable String declarationisref) {
        return declarationISService.montantWithNoPenality(declarationisref);
    }

    @GetMapping("/montantpenality/{declarationisref}/{datefacture}/{datepaiment}")
    public double montantPenality(@PathVariable String declarationisref,
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date datefacture,
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date datepaiment) {
        return declarationISService.montantPenality(declarationisref, datefacture, datepaiment);
    }

     @GetMapping("/montantWithPenality/{declarationisref}/{datefacture}/{datepaiment}")
    public double montantWithPenality(@PathVariable String declarationisref,
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date datefacture,
            @PathVariable @DateTimeFormat(pattern = "dd-MM-yyyy") Date datepaiment) {
        return declarationISService.montantWithPenality(declarationisref, datefacture, datepaiment);
    }
     @PutMapping("/update/")
    public int update(@RequestBody  DeclarationIS declarationIS) {
        return declarationISService.update(declarationIS);
    }
}
