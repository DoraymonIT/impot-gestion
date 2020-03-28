package com.gestionimpot.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestionimpot.bean.Societe;
import com.gestionimpot.service.facade.SocieteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("impot/societe")
public class SocieteRestController {
	@Autowired
	SocieteService societeService;

	@GetMapping("/typeSociete/{typeSociete}")
	public List<Societe> findByTypeSociete(@PathVariable String typeSociete) {
		return societeService.findByTypeSociete(typeSociete);
	}

	@GetMapping("/ref/{ref}")
	public Societe findByRef(@PathVariable String ref) {
		return societeService.findByRef(ref);
	}

	@GetMapping("/nom/{nom}")
	public List<Societe> findByNom(@PathVariable String nom) {
		return societeService.findByNom(nom);
	}

	@GetMapping("/")
	public List<Societe> findAll() {
		return societeService.findAll();
	}

	@GetMapping("/adresse/{adresse}")
	public List<Societe> findByAdresse(@PathVariable String adresse) {
		return societeService.findByAdresse(adresse);
	}

	@GetMapping("/capital/{capital}")
	public List<Societe> findByCapital(@PathVariable Double capital) {
		return societeService.findByCapital(capital);
	}

	@GetMapping("/nbrEmployes/{nbrEmployes}")
	public List<Societe> findByNbrEmployes(@PathVariable Double nbrEmployes) {
		return societeService.findByNbrEmployes(nbrEmployes);
	}

	@PostMapping("/")
	public int save(@RequestBody Societe societe) {
		return societeService.save(societe);
	}

	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable String ref) {
		return societeService.deleteByRef(ref);
	}

	@PostMapping("/update")
	public int update(@RequestBody Societe societe) {
		return societeService.update(societe);
	}

}