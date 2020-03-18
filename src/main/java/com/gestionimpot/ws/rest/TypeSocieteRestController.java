package com.gestionimpot.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestionimpot.bean.TypeSociete;
import com.gestionimpot.service.facade.TypeSocieteService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("impot/typeSociete")
public class TypeSocieteRestController {
	@Autowired
	private TypeSocieteService typeSocieteService;

	@GetMapping("/libelle/{libelle}")
	public TypeSociete findByLibelle(@PathVariable String libelle) {
		return typeSocieteService.findByLibelle(libelle);
	}

	@GetMapping("/")
	public List<TypeSociete> findAll() {
		return typeSocieteService.findAll();
	}

	@DeleteMapping("/delete/{libelle}")
	public int deleteByLibelle(@PathVariable String libelle) {
		return typeSocieteService.deleteByLibelle(libelle);
	}

	@PostMapping("/")
	public int save(@RequestBody TypeSociete typeSociete) {
		return typeSocieteService.save(typeSociete);
	}


}