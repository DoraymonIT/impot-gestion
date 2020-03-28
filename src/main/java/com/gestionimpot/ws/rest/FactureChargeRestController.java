package com.gestionimpot.ws.rest;

import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.service.facade.FactureChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/impot/FactureCharge")

public class FactureChargeRestController {
	
    
	@Autowired
    FactureChargeService factureChargeService ;
	@GetMapping("/refsociete/ref/{ref}")
	public List<FactureCharge> findBySocieteRef(@PathVariable String ref) {
		return factureChargeService.findBySocieteRef(ref);
	}
    @GetMapping("/")
    public List<FactureCharge> findAll() {
        return factureChargeService.findAll();
    }
    @GetMapping("/ref/{ref}")
    public FactureCharge findByRef(@PathVariable  String ref) {
        return factureChargeService.findByRef(ref);
    }

    @GetMapping("/fournisseurCin/{fournisseurCin}")
    public List<FactureCharge> findByFournisseurCin(@PathVariable  String fournisseurCin) {
        return factureChargeService.findByFournisseurCin(fournisseurCin);
    }
    @PostMapping("/")
    public int save(@RequestBody  FactureCharge factureCharge) {
        return factureChargeService.save(factureCharge);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable  String ref) {
        return factureChargeService.deleteByRef(ref);
    }
    @GetMapping("/numeroFacture/{numeroFacture}")
	public FactureCharge findByNumeroFacture(Long numeroFacture) {
		return factureChargeService.findByNumeroFacture(numeroFacture);
	}
    @GetMapping("/montantHT/{montantHT}")
	public List<FactureCharge> findByMontantHT(double montantHT) {
		return factureChargeService.findByMontantHT(montantHT);
	}
    @GetMapping("/montantTTC/{montantTTC}")
	public List<FactureCharge> findByMontantTTC(double montantTTC) {
		return factureChargeService.findByMontantTTC(montantTTC);
	}
    @GetMapping("/tva/{tva}")
	public List<FactureCharge> findByTva(double tva) {
		return factureChargeService.findByTva(tva);
	}
    @GetMapping("/datePaiement/{datePaiement}")
	public List<FactureCharge> findByDatePaiement(Date datePaiement) {
		return factureChargeService.findByDatePaiement(datePaiement);
	}
    @GetMapping("/dateFacturation/{dateFacturation}")
	public List<FactureCharge> findByDateFacturation(Date dateFacturation) {
		return factureChargeService.findByDateFacturation(dateFacturation);
	}
    @PostMapping("/upd/")
	public int update(@RequestBody FactureCharge factureCharge) {
		return factureChargeService.update(factureCharge);
	}
    
     
    
    
}
