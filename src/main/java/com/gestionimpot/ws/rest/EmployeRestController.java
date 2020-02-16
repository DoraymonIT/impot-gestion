package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.service.facade.EmployeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("impot/societe/employe")
@RestController
public class EmployeRestController {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/numeroEmploye/{numeroEmploye}")
    public Employe findBynNumeroEmploye(@PathVariable Long numeroEmploye) {
        return employeService.findBynNumeroEmploye(numeroEmploye);
    }

    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }

    @GetMapping("/cin/{cin}")
    public Employe findByCin(@PathVariable String cin) {
        return employeService.findByCin(cin);
    }

    @GetMapping("/salaire/{salaire}")
    public List<Employe> findBySalaire(@PathVariable double salaire) {
        return employeService.findBySalaire(salaire);
    }

    @PostMapping("/")
    public int save(@RequestBody Employe employe) {
        return employeService.save(employe);
    }

}
