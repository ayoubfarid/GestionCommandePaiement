package com.GestionCommande.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionCommande.bean.Commande;
import com.GestionCommande.bean.Paiement;
import com.GestionCommande.service.PaiementService;

@RestController
@RequestMapping(value="stock/paiement")
public class PaiementRestApi {
	@Autowired
	private PaiementService paiementservice;
	
	
	@GetMapping("/commande/reference/{reference}")
	public List<Paiement> findByCommandeReference(@PathVariable String reference) {
		return paiementservice.findByCommandeReference(reference);
	}
	
	@DeleteMapping("/refeence/{reference}")
	public int deleteByCommandeReference(@PathVariable String reference) {
		return paiementservice.deleteByCommandeReference(reference);
	}
	
	@PostMapping("/")
	public int save(@RequestBody Paiement paiement) {
		return paiementservice.save(paiement);
	}
	@GetMapping("/reference/{reference}")
	public Commande findByReference(@PathVariable String reference) {
		return paiementservice.findByReference(reference);
	}
	@GetMapping("/")
	public List<Paiement> findAll() {
		return paiementservice.findAll();
	}

	public void delete(Paiement entity) {
		paiementservice.delete(entity);
	}

	public int hashCode() {
		return paiementservice.hashCode();
	}

	public boolean equals(Object obj) {
		return paiementservice.equals(obj);
	}

	public String toString() {
		return paiementservice.toString();
	}
	
}
