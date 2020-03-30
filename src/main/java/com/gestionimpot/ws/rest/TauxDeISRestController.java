package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.TauxDeIS;
import com.gestionimpot.service.facade.TauxDeISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/impot/TauxDeIS")
public class TauxDeISRestController {
    @Autowired
    TauxDeISService tauxDeISService ;
    
     @GetMapping("/pourcentageRetard/{dateFacturation}/{datePaiement}")
    public double pourcentageRetard(@PathVariable @DateTimeFormat(pattern= "yyyy-MM-dd")Date dateFacturation,
            @PathVariable @DateTimeFormat(pattern= "yyyy-MM-dd") Date datePaiement) 
    {
        return tauxDeISService.pourcentageRetard(dateFacturation, datePaiement);
    }
    
    
    @GetMapping("/dateDebut/{dateDebut}")
    public List<TauxDeIS> findByDateDebut(@PathVariable  @DateTimeFormat(pattern= "yyyy-MM-dd") Date dateDebut) {
        return tauxDeISService.findByDateDebut(dateDebut);
    }
    @GetMapping("/")
    public List<TauxDeIS> findAll() {
        return tauxDeISService.findAll();
    }
    @GetMapping("/dateFin/{dateFin}")
    public List<TauxDeIS> findByDateFin(@PathVariable  @DateTimeFormat(pattern= "yyyy-MM-dd") Date dateFin) {
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
    @PutMapping("/update")
    public int update(@RequestBody  TauxDeIS tauxDeIS) {
        return tauxDeISService.update(tauxDeIS);
    }
}
