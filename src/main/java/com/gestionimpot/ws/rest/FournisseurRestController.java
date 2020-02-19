package com.gestionimpot.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionimpot.bean.Fournisseur;
import com.gestionimpot.service.facade.FournisseurService;
@RestController
	@RequestMapping("impot/fournisseur")
public class FournisseurRestController {
@Autowired
 FournisseurService fournisseurService;
@GetMapping("/{cin}/cin")
public Fournisseur findByCin(String cin) {
	return fournisseurService.findByCin(cin);
}
@PostMapping("/")
public void save(Fournisseur fournisseur) {
	fournisseurService.save(fournisseur);
}
@GetMapping("/")
public List<Fournisseur> findAll() {
	return fournisseurService.findAll();
}

}
