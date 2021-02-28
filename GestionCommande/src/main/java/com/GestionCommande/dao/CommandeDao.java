package com.GestionCommande.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestionCommande.bean.Commande;

public interface CommandeDao extends JpaRepository<Commande,Long>{
	Commande findByReference(String reference);
	int deleteByReference(String reference);

}
