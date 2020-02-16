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

    /**
     * @param societe
     * @return
     * @see com.gestionimpot.service.facade.SocieteService#save(com.gestionimpot.bean.Societe)
     */
    @PostMapping("/")
    public int save(@RequestBody Societe societe) {
        return societeService.save(societe);
    }

    /**
     * @param ref
     * @return
     * @see com.gestionimpot.service.facade.SocieteService#findByRef(java.lang.String)
     */
    @GetMapping("/ref/{ref}")
    public Societe findByRef(@PathVariable String ref) {
        return societeService.findByRef(ref);
    }

    /**
     * @param nom
     * @return
     * @see com.gestionimpot.service.facade.SocieteService#findByNom(java.lang.String)
     */
    @GetMapping("/nom/{nom}")
    public List<Societe> findByNom(@PathVariable String nom) {
        return societeService.findByNom(nom);
    }

    /**
     * @return
     * @see com.gestionimpot.service.facade.SocieteService#findAll()
     */
    @GetMapping("/")
    public List<Societe> findAll() {
        return societeService.findAll();
    }

    /**
     * @param libelle
     * @return
     * @see com.gestionimpot.service.facade.SocieteService#findByTypeSocieteLibelle(java.lang.String)
     */
    @GetMapping("/libelle/{libelle}")
    public List<Societe> findByTypeSocieteLibelle(@PathVariable String libelle) {
        return societeService.findByTypeSocieteLibelle(libelle);
    }

    /**
     * @param adresse
     * @return
     * @see com.gestionimpot.service.facade.SocieteService#findByAdresse(java.lang.String)
     */
    @GetMapping("/adresse/{adresse}")
    public List<Societe> findByAdresse(@PathVariable String adresse) {
        return societeService.findByAdresse(adresse);
    }

    /**
     * @param capital
     * @return
     * @see com.gestionimpot.service.facade.SocieteService#findByCapital(java.lang.Double)
     */
    @GetMapping("/capital/{capital}")
    public List<Societe> findByCapital(@PathVariable Double capital) {
        return societeService.findByCapital(capital);
    }

    /**
     * @param nbrEmployes
     * @return
     * @see com.gestionimpot.service.facade.SocieteService#findByNbrEmployes(java.lang.Double)
     */
    @GetMapping("/nbrEmployes/{nbrEmployes}")
    public List<Societe> findByNbrEmployes(@PathVariable Double nbrEmployes) {
        return societeService.findByNbrEmployes(nbrEmployes);
    }



}