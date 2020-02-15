package com.gestionimpot.ws.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionimpot.bean.TypeSociete;
import com.gestionimpot.service.facade.TypeSocieteService;

//j

@RestController
@RequestMapping("impot/typeSociete")
public class TypeSocieteRestController {
    @Autowired
    private TypeSocieteService typeSocieteService;

    /**
     * @param typeSociete
     * @return
     * @see com.gestionimpot.service.facade.TypeSocieteService#save(com.gestionimpot.bean.TypeSociete)
     */
    @PostMapping("/")
    public int save(@RequestBody TypeSociete typeSociete) {
        return typeSocieteService.save(typeSociete);
    }

    /**
     * @param libelle
     * @return
     * @see com.gestionimpot.service.facade.TypeSocieteService#findByLibelle(java.lang.String)
     */
    @GetMapping("/libelle/{libelle}")
    public List<TypeSociete> findByLibelle(@PathVariable String libelle) {
        return typeSocieteService.findByLibelle(libelle);
    }


}