package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.DeclarationIR;
import com.gestionimpot.service.facade.DeclarationIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("impot/declarationIR")
public class DeclarationIRRestController {
@Autowired
    private DeclarationIRService declarationIRService ;
    @GetMapping("/employe/{employe}")
    public List<DeclarationIR> findByEmploye(@PathVariable String employe) {
        return declarationIRService.findByEmploye(employe);
    }
    @PostMapping("/")
    public int save(@RequestBody DeclarationIR declarationIR) {
        return declarationIRService.save(declarationIR);
    }
}
