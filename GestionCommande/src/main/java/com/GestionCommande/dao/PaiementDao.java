package com.GestionCommande.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionCommande.bean.Paiement;
// ref commande : liste payement
@Repository
public interface PaiementDao extends JpaRepository<Paiement,Long>{
	
	Paiement findByReference(String refrence);
	List <Paiement> findByCommandeReference(String reference);
	int deleteByCommandeReference(String reference);

}
