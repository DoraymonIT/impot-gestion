/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.Bibleotheque.ws.rest;

import com.fst.Bibleotheque.bean.Emprunt;
import com.fst.Bibleotheque.service.facade.ServiceEmprunt;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dell
 */
@RequestMapping("bibleo/emprunt")
@RestController
public class EmpruntRestController {
    @Autowired
    private ServiceEmprunt serviceEmprunt;

    @PostMapping("/")
    public int save(@RequestBody  Emprunt emprunt) {
        return serviceEmprunt.save(emprunt);
    }

//    @GetMapping("/")
//    public List<Emprunt> findByDateRestituerEffe(Date ddd) {
//        return serviceEmprunt.findByDateRestituerEffe(ddd);
//    }
    @GetMapping("/")
    public List<Emprunt> findAll() {
        return serviceEmprunt.findAll();
    }
    
    
}
