package com.gestionimpot.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionimpot.bean.FactureGain;
import com.gestionimpot.service.facade.FactureGainService;

@RestController
@RequestMapping("/impot/factureGain")
public class FactureGainRestController {
	
	@Autowired
	private FactureGainService factureGainService;
	@PostMapping("/")
	public int save(@RequestBody  FactureGain factureGain) {
		return factureGainService.save(factureGain);
	}
	@GetMapping("/")
	public List<FactureGain> findAll() {
		return factureGainService.findAll();
	}
	@GetMapping("/numeroFacture/{numeroFacture}")
	public FactureGain findByNumeroFacture(Long numeroFacture) {
		return factureGainService.findByNumeroFacture(numeroFacture);
	}
}
