package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.DeclarationIS;
import com.gestionimpot.bean.TauxDeIS;
import com.gestionimpot.service.facade.TauxDeISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.joda.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/impot/TauxDeIS")
public class TauxDeISRestController {
    @Autowired
    TauxDeISService tauxDeISService ;
    @GetMapping("/pourcentageRetard/{dateFacturation}/{datePaiement}")
    public double pourcentageRetard(@PathVariable LocalDate dateFacturation, @PathVariable LocalDate datePaiement) {
        return tauxDeISService.pourcentageRetard(dateFacturation, datePaiement);
    }
    @GetMapping("/declarationIS/{declarationIS}")
    public TauxDeIS findByDeclarationIS(@PathVariable  String declarationIS) {
        return tauxDeISService.findByDeclarationIS(declarationIS);
    }
    @GetMapping("/dateDebut/{dateDebut}")
    public List<TauxDeIS> findByDateDebut(@PathVariable  Date dateDebut) {
        return tauxDeISService.findByDateDebut(dateDebut);
    }
    @GetMapping("/")
    public List<TauxDeIS> findAll() {
        return tauxDeISService.findAll();
    }
    @GetMapping("/dateFin/{dateFin}")
    public List<TauxDeIS> findByDateFin(@PathVariable  Date dateFin) {
        return tauxDeISService.findByDateFin(dateFin);
    }
    @GetMapping("/montantMin/{montantMin}")
    public List<TauxDeIS> findByMontantMin(@PathVariable  double montantMin) {
        return tauxDeISService.findByMontantMin(montantMin);
    }
    @GetMapping("/montantMax/{montantMax}")
    public List<TauxDeIS> findByMontantMax(@PathVariable double montantMax) {
        return tauxDeISService.findByMontantMax(montantMax);
    }
    @GetMapping("/ref/{ref}")
    public TauxDeIS findByRef(@PathVariable  String ref) {
        return tauxDeISService.findByRef(ref);
    }
    @DeleteMapping("/delete/{ref}")
    public int deleteByRef(@PathVariable  String ref) {
        return tauxDeISService.deleteByRef(ref);
    }
    @PostMapping("/")
    public int save(@RequestBody  TauxDeIS tauxDeIS) {
        return tauxDeISService.save(tauxDeIS);
    }
}
