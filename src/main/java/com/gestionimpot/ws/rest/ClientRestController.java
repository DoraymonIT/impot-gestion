package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.Client;
import com.gestionimpot.service.facade.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("impot/client")

public class ClientRestController {
    @Autowired
    private   ClientService clientService ;
    @GetMapping("/cin/{cin}")
    public Client findByCin(@PathVariable String cin) {
        return clientService.findByCin(cin);
    }
    @GetMapping("/nom/{nom}")
    public Client findByNom(@PathVariable String nom) {
        return clientService.findByNom(nom);
    }
    @GetMapping("/")
    public List<Client> findAll() {
        return clientService.findAll();
    }
}
