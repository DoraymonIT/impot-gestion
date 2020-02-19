package com.gestionimpot.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionimpot.bean.Societe;
import com.gestionimpot.service.facade.SocieteService;

@RestController
@RequestMapping("impot/societe")
public class SocieteRestController {
    @Autowired
    private SocieteService societeService;

    @PostMapping("/")
    public int save(@RequestBody Societe societe) {
        return societeService.save(societe);
    }

    @GetMapping("/ref/{ref}")
    public Societe findByRef(@PathVariable String ref) {
        return societeService.findByRef(ref);
    }


    @GetMapping("/nom/{nom}")
    public List<Societe> findByNom(@PathVariable String nom) {
        return societeService.findByNom(nom);
    }

    @GetMapping("/")
    public List<Societe> findAll() {
        return societeService.findAll();
    }

    @GetMapping("/libelle/{libelle}")
    public List<Societe> findByTypeSocieteLibelle(@PathVariable String libelle) {
        return societeService.findByTypeSocieteLibelle(libelle);
    }

    @GetMapping("/adresse/{adresse}")
    public List<Societe> findByAdresse(@PathVariable String adresse) {
        return societeService.findByAdresse(adresse);
    }

    @GetMapping("/capital/{capital}")
    public List<Societe> findByCapital(@PathVariable Double capital) {
        return societeService.findByCapital(capital);
    }

    @GetMapping("/nbrEmployes/{nbrEmployes}")
    public List<Societe> findByNbrEmployes(@PathVariable Double nbrEmployes) {
        return societeService.findByNbrEmployes(nbrEmployes);
    }



}