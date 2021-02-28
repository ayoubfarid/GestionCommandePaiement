package com.GestionCommande.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionCommande.bean.Commande;
import com.GestionCommande.service.CommandeService;

@RestController
@RequestMapping(value="stock/commande")
public class CommandeRestApi {
	@Autowired
	private CommandeService commandeservice;
	
	@DeleteMapping("/refeence/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return commandeservice.deleteByReference(reference);
	}
	@GetMapping("/reference/{reference}")
	public Commande findByReference(@PathVariable String reference) {
		return commandeservice.findByReference(reference);
	}
	@GetMapping("/")
	public List<Commande> findAll() {
		return commandeservice.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Commande commande) {
		return commandeservice.save(commande);
	}
	@PutMapping("/")
	public void update( @RequestBody Commande commande) {
		commandeservice.update(commande);
	}

	public int hashCode() {
		return commandeservice.hashCode();
	}

	public boolean equals(Object obj) {
		return commandeservice.equals(obj);
	}

	public String toString() {
		return commandeservice.toString();
	}
	

}
