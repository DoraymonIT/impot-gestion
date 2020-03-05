package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.TauxDeIR;
import com.gestionimpot.service.facade.TauxDeIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("impot/tauxDeIR")
public class TauxDeIRRestController {
    @Autowired
    private TauxDeIRService tauxDeIRService ;
    @GetMapping("/")
    public List<TauxDeIR> findAll() {
        return tauxDeIRService.findAll();
    }
    @GetMapping("/dateDebut/{dateDebut}")
    public List<TauxDeIR> findByDateDebut(@PathVariable  Date dateDebut) {
        return tauxDeIRService.findByDateDebut(dateDebut);
    }
    @GetMapping("/dateFin/{dateFin}")
    public List<TauxDeIR> findByDateFin(@PathVariable Date dateFin) {
        return tauxDeIRService.findByDateFin(dateFin);
    }
    @GetMapping("/salaireMin/{salaireMin}")
    public List<TauxDeIR> findBySalaireMin(@PathVariable Double salaireMin) {
        return tauxDeIRService.findBySalaireMin(salaireMin);
    }
    @GetMapping("/salaireMax/{salaireMax}")
    public List<TauxDeIR> findBySalaireMax(@PathVariable Double salaireMax) {
        return tauxDeIRService.findBySalaireMax(salaireMax);
    }
    @GetMapping("/pourcentage/{pourcentage}")
    public List<TauxDeIR> findByPourcentage(@PathVariable Double pourcentage) {
        return tauxDeIRService.findByPourcentage(pourcentage);
    }
    @GetMapping("/ref/{ref}")
    public TauxDeIR findByRef(@PathVariable String ref) {
        return tauxDeIRService.findByRef(ref);
    }
    @PostMapping("/")
    public int save(@RequestBody TauxDeIR tauxDeIR) {
        return tauxDeIRService.save(tauxDeIR);
    }
    @DeleteMapping("/delete/ref")
    public int deleteByRef(@PathVariable String ref) {
        return tauxDeIRService.deleteByRef(ref);
    }
    @PostMapping("/update")
    public int update(@RequestBody  TauxDeIR tauxDeIR) {
        return tauxDeIRService.update(tauxDeIR);
    }
}
