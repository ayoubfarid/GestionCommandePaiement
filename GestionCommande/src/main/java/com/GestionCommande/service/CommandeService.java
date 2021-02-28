package com.GestionCommande.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GestionCommande.bean.Commande;
import com.GestionCommande.dao.CommandeDao;

@Service 
public class CommandeService {
	@Autowired
	private CommandeDao commandedao;
	@Autowired
	PaiementService paiementservice;
     @Transactional
	public int deleteByReference(String reference) {
		int resultPaiement=paiementservice.deleteByCommandeReference(reference);
		int resultCommande =commandedao.deleteByReference(reference);
		return resultPaiement+resultCommande;
	}

	public Commande findByReference(String reference) {
		return commandedao.findByReference(reference);
	}

	public List<Commande> findAll() {
		return commandedao.findAll();
	}

	public void delete(Commande commande) {
		commandedao.delete(commande);
	}
	
	public int save(Commande commande)
	{
		if(findByReference(commande.getReference()) != null)
				return -1;
		else if (commande.getTotal() < commande.getTotalPaye() ) 
				return -2;						
		else {
			commandedao.save(commande);
			return 1;
		}
		
				
				
	}
	public void update (Commande commande) {
		commandedao.save(commande);
	}
	
}
