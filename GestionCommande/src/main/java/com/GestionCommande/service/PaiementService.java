package com.GestionCommande.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionCommande.bean.Commande;
import com.GestionCommande.bean.Paiement;

import com.GestionCommande.dao.PaiementDao;

@Service 
public class PaiementService {
	@Autowired
	PaiementDao paimentdao;
	@Autowired
	CommandeService commandeservice;
	
	
	

	public List<Paiement> findByCommandeReference(String reference) {
		return paimentdao.findByCommandeReference(reference);
	}

	public int deleteByCommandeReference(String reference) {
		return paimentdao.deleteByCommandeReference(reference);
	}
	
	public  int save(Paiement paiement) {
		
		if(findByReference(paiement.getReference())!= null)
			return -1;
		
		Commande commande = commandeservice.findByReference(paiement.getCommande().getReference());
		paiement.setCommande(commande);
		if(commande==null) return -2;
		else if (commande.getTotalPaye()+paiement.getMontant()>commande.getTotal())
			return -2;
		else {
			double nvtotal = commande.getTotalPaye()+paiement.getMontant();
			commande.setTotalPaye(nvtotal);
			commandeservice.update(commande);
			paimentdao.save(paiement);
			return 1;
		}
			
		
		
	}

	public Commande findByReference(String reference) {
		return commandeservice.findByReference(reference);
	}

	public List<Paiement> findAll() {
		return paimentdao.findAll();
	}
	@Transactional
	public void delete(Paiement entity) {
		paimentdao.delete(entity);
	}
	

}
