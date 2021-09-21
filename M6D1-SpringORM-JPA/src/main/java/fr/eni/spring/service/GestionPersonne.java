package fr.eni.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import fr.eni.spring.bean.Personne;
import fr.eni.spring.dao.PersonneDAO;

// Annotation pour déclarer un composant géré par spring qui pourra être injecté.
// Service est de deuxième tiers, il n'est pas persisaent.
@Service(value="gestionPersonne")
public class GestionPersonne {
	// Classe intermédiaire entre main et classe persistance
	
	// Comme la DAO est injectable, j'indique à Spring
	// je demande à Spring de m'injecter une instance d'une classe qui implémente personneDAo
	@Autowired
	PersonneDAO pdao;
	
	public List<Personne> listePersonnes() {
		return pdao.findAll();
	}
	
	public Personne rechercherPersonne(int id) {
		return pdao.findById(id);
	}

	public Personne rechercherDernier() {
		return pdao.findLast();
	}
	
	public void ajouterPersonne(Personne p) {
		pdao.add(p);
	}
	
	public void modifierPersonne(Personne p) {
		pdao.update(p);
	}
	
	public void supprimerPersonne(Personne p) {
		pdao.delete(p);
	}
	
	public void supprimerPersonne(int id) {
		pdao.delete(id);
	}
	
	public void supprimerPersonne(String nom) {
		pdao.delete(nom);
	}
	
}
