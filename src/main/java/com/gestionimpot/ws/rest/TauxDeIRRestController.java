package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.TauxDeIR;
import com.gestionimpot.service.facade.TauxDeIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/")
    public int save(@RequestBody  TauxDeIR tauxDeIR) {
        return tauxDeIRService.save(tauxDeIR);
    }
}
