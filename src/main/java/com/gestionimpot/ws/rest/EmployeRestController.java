package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.Employe;
import com.gestionimpot.service.facade.EmployeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("impot/employe")
public class EmployeRestController {

    @Autowired
    private EmployeService employeService;
    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }
    @GetMapping("/nom/{nom}")
    public List<Employe> findByNom(@PathVariable  String nom) {
        return employeService.findByNom(nom);
    }

    @GetMapping("/prenom/{prenom}")
    public List<Employe> findByPrenom(@PathVariable  String prenom) {
        return employeService.findByPrenom(prenom);
    }
    @GetMapping("/adresseHabit/{adresseHabit}")
    public List<Employe> findByAdresseHabit(@PathVariable  String adresseHabit) {
        return employeService.findByAdresseHabit(adresseHabit);
    }
    @GetMapping("/adresseMail/{adresseMail}")
    public List<Employe> findByAdresseMail(@PathVariable  String adresseMail) {
        return employeService.findByAdresseMail(adresseMail);
    }
    @GetMapping("/sexe/{sexe}")
    public List<Employe> findBySexe(@PathVariable  String sexe) {
        return employeService.findBySexe(sexe);
    }
    @GetMapping("/prime/{prime}")
    public List<Employe> findByPrime(@PathVariable  double prime) {
        return employeService.findByPrime(prime);
    }
    @GetMapping("/cin/{cin}")
    public Employe findByCin(@PathVariable  String cin) {
        return employeService.findByCin(cin);
    }
    @GetMapping("/salaire/{salaire}")
    public List<Employe> findBySalaire(@PathVariable  double salaire) {
        return employeService.findBySalaire(salaire);
    }
    @GetMapping("/societe/{societe}")
    public List<Employe> findBySociete(@PathVariable  String societe) {
        return employeService.findBySociete(societe);
    }
    @PostMapping("/")
    public int save(@RequestBody  Employe employe) {
        return employeService.save(employe);
    }
    @DeleteMapping("/delete/{cin}")
    public int deleteByCin(@PathVariable  String cin) {
        return employeService.deleteByCin(cin);
    }

    @PutMapping("/update/cin/{cne}/nouveauSal/{NouveauSalaire}")
    public int updateSalaire(@PathVariable String cne,@PathVariable double NouveauSalaire) {
        return employeService.updateSalaire(cne, NouveauSalaire);
    }
    
}
