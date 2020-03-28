package com.gestionimpot.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gestionimpot.bean.FactureGain;
import com.gestionimpot.service.facade.FactureGainService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
	@GetMapping("/clientCne/{clientCne}")
	public List<FactureGain> findByClientCne(@PathVariable  String clientCne) {
		return factureGainService.findByClientCne(clientCne);
	}
	@DeleteMapping("/ref/{ref}")
	public int deleteByRef(@PathVariable Long ref) {
		return factureGainService.deleteByRef(ref);
	}
}
