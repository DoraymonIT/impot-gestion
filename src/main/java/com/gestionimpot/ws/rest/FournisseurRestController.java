package com.gestionimpot.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestionimpot.bean.Fournisseur;
import com.gestionimpot.service.facade.FournisseurService;
@RestController
@RequestMapping("impot/fournisseur")
public class FournisseurRestController {
@Autowired
    FournisseurService fournisseurService ;
    @GetMapping("/cin/{cin}")
    public Fournisseur findByCin(@PathVariable  String cin) {
        return fournisseurService.findByCin(cin);
    }
    @GetMapping("/nom/{nom}")
    public List<Fournisseur> findByNom(String nom) {
        return fournisseurService.findByNom(nom);
    }
    @GetMapping("/")
    public List<Fournisseur> findAll() {
        return fournisseurService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody  Fournisseur fournisseur) {
        return fournisseurService.save(fournisseur);
    }
    @DeleteMapping("/delete/{cin}")
    public int deleteByCin(@PathVariable  String cin) {
        return fournisseurService.deleteByCin(cin);
    }
}
