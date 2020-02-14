package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.DeclarationTva;
import com.gestionimpot.service.facade.DeclarationTvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("impot/declarationTVA")
public class DeclarationTVARestController {
    @Autowired
    private DeclarationTvaService declarationTvaService ;
    @GetMapping("/societe/{societe}")
    public List<DeclarationTva> findBySociete(@PathVariable String societe) {
        return declarationTvaService.findBySociete(societe);
    }
    @PostMapping("/")
    public int save(@RequestBody DeclarationTva declarationTva) {
        return declarationTvaService.save(declarationTva);
    }
}
