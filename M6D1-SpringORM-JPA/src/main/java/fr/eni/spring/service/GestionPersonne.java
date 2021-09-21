package fr.eni.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import fr.eni.spring.bean.Personne;
import fr.eni.spring.dao.PersonneDAO;

// Annotation pour d�clarer un composant g�r� par spring qui pourra �tre inject�.
// Service est de deuxi�me tiers, il n'est pas persisaent.
@Service(value="gestionPersonne")
public class GestionPersonne {
	// Classe interm�diaire entre main et classe persistance
	
	// Comme la DAO est injectable, j'indique � Spring
	// je demande � Spring de m'injecter une instance d'une classe qui impl�mente personneDAo
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
