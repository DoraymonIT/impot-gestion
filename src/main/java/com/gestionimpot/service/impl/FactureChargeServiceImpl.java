package com.gestionimpot.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionimpot.bean.DeclarationTva;
import com.gestionimpot.bean.FactureCharge;
import com.gestionimpot.bean.Fournisseur;
import com.gestionimpot.bean.Societe;
import com.gestionimpot.dao.DeclarationTvaDao;
import com.gestionimpot.dao.FactureChargeDao;
import com.gestionimpot.dao.FournisseurDao;
import com.gestionimpot.dao.SocieteDao;
import com.gestionimpot.service.facade.FactureChargeService;
import com.gestionimpot.service.facade.FournisseurService;

@Service
public class FactureChargeServiceImpl implements FactureChargeService {
	@Autowired
	FactureChargeDao factureChargeDao;
	@Autowired
	FournisseurDao fournisseurDao;
	@Autowired
	SocieteDao societeDao;
	@Autowired
	DeclarationTvaDao declarationTvaDao;
	@Autowired
	FournisseurService fournisseurService;

	@Override
	public List<FactureCharge> findAll() {
		return factureChargeDao.findAll();
	}

	@Override
	public FactureCharge findByRef(String ref) {
		return factureChargeDao.findByRef(ref);
	}

	@Override
	public List<FactureCharge> findByFournisseurCin(String fournisseurCin) {
		return factureChargeDao.findByFournisseurCin(fournisseurCin);
	}

	@Override
	public FactureCharge findByNumeroFacture(Long numeroFacture) {
		return factureChargeDao.findByNumeroFacture(numeroFacture);
	}

	@Override
	public List<FactureCharge> findByMontantHT(double montantHT) {
		return factureChargeDao.findByMontantHT(montantHT);
	}

	@Override
	public List<FactureCharge> findByMontantTTC(double montantTTC) {
		return factureChargeDao.findByMontantTTC(montantTTC);
	}

	@Override
	public List<FactureCharge> findByTva(double tva) {
		return factureChargeDao.findByTva(tva);
	}

	@Override
	public List<FactureCharge> findByDatePaiement(Date datePaiement) {
		return factureChargeDao.findByDatePaiement(datePaiement);
	}

	@Override
	public List<FactureCharge> findByDateFacturation(Date dateFacturation) {
		return factureChargeDao.findByDateFacturation(dateFacturation);
	}

	@Override
	public int save(FactureCharge factureCharge) {
		FactureCharge foundedFactureCharge = factureChargeDao.findByRef(factureCharge.getRef());
		Fournisseur foundedFournisseur = fournisseurDao.findByCin(factureCharge.getFournisseurCin());
		Societe foundedSociete = societeDao.findByRef(factureCharge.getSocieteRef());
		DeclarationTva foundedDeclaration = declarationTvaDao.findByRef(factureCharge.getDeclarationRef());

		if (foundedFactureCharge != null)
			return -1;
		else if (foundedFournisseur == null)
			return -2;
		else if (foundedSociete == null)
			return -3;
		else if (foundedDeclaration == null)
			return -4;

		else {
			factureCharge.setFournisseur(foundedFournisseur);
			factureCharge.setSociete(foundedSociete);
			factureCharge.setDeclarationTva(foundedDeclaration);

			factureChargeDao.save(factureCharge);
			return 1;
		}

	}

	@Override
	public int deleteByRef(String ref) {
		FactureCharge foundedFactureCharge = factureChargeDao.findByRef(ref);
		if (foundedFactureCharge == null)
			return -1;
		else {
			factureChargeDao.delete(foundedFactureCharge);
			return 1;
		}
	}

	@Override
	public int update(FactureCharge factureCharge) {
		FactureCharge foundedFactureCharge = factureChargeDao.findByRef(factureCharge.getRef());
		if (foundedFactureCharge == null)
			return -1;
		Fournisseur foundedFournisseur = foundedFactureCharge.getFournisseur();
		DeclarationTva foundedDeclarationTva = foundedFactureCharge.getDeclarationTva();
		Societe foundedSociete = foundedFactureCharge.getSociete();

		if (factureCharge.getFournisseurCin() != null) {
			foundedFournisseur = fournisseurDao.findByCin(factureCharge.getFournisseurCin());
			foundedFactureCharge.setFournisseurCin(factureCharge.getFournisseurCin());
			if (foundedFournisseur == null)
				return -2;
		}
		if (factureCharge.getDeclarationRef() != null) {
			foundedDeclarationTva = declarationTvaDao.findByRef(factureCharge.getDeclarationRef());
			foundedFactureCharge.setDeclarationRef(factureCharge.getDeclarationRef());
			if (foundedDeclarationTva == null)
				return -3;

		}
		if (factureCharge.getSocieteRef() != null) {
			foundedSociete = societeDao.findByRef(factureCharge.getSocieteRef());
			foundedFactureCharge.setSocieteRef(factureCharge.getSocieteRef());
			if (foundedSociete == null)
				return -4;

		}

		foundedFactureCharge.setFournisseur(foundedFournisseur);
		foundedFactureCharge.setDeclarationTva(foundedDeclarationTva);
		foundedFactureCharge.setSociete(foundedSociete);
		foundedFactureCharge.setDateFacturation(factureCharge.getDateFacturation());
		foundedFactureCharge.setDatePaiement(factureCharge.getDatePaiement());
		foundedFactureCharge.setMontantHT(factureCharge.getMontantHT());
		foundedFactureCharge.setMontantTTC(factureCharge.getMontantTTC());
		foundedFactureCharge.setTva(factureCharge.getTva());
		foundedFactureCharge.setNomFacture(factureCharge.getNomFacture());
		factureChargeDao.save(foundedFactureCharge);
		return 1;
	}

	@Override
	public List<FactureCharge> findBySocieteRef(String ref) {
		return factureChargeDao.findBySocieteRef(ref);
	}

}
