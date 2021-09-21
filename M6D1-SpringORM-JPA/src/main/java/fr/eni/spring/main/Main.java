package fr.eni.spring.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.spring.bean.Personne;
import fr.eni.spring.service.GestionPersonne;

public class Main {

	public static void main(String[] args) {
		// Récupérer les informations de contexte
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		// Puis renvoyer un objet de type GestionPersonne
		// premier paramètre: id définit dans le Service (élem de type composant), Spring créer donc une instance
		// de cette classe là et l'injecte dans le main
		GestionPersonne gp = context.getBean("gestionPersonne", GestionPersonne.class);
		
		
		// Exemple de CRUD
		List<Personne> liste = gp.listePersonnes();
		for (Personne personne : liste) {
			System.out.println(personne);
		}
		
		Personne p1 = new Personne("Lebrun", "Vincent", 35);
		System.out.println("p1 avant ajout: "+p1);
		gp.ajouterPersonne(p1);
		System.out.println("p1 après ajout: "+p1);
		
		p1.setNom("Leblond");
		gp.modifierPersonne(p1);
		
		System.out.println("\nListe des personnes apres modif de p1: ");
		liste = gp.listePersonnes();
		for (Personne personne : liste) {
			System.out.println(personne);
		}
		
		gp.supprimerPersonne(p1);
		
		System.out.println("\nListe des personnes apres supp de p1: ");
		liste = gp.listePersonnes();
		for (Personne personne : liste) {
			System.out.println(personne);
		}
		
		p1 = new Personne("Lebrun", "Vincent", 35);
		gp.ajouterPersonne(p1);
		gp.supprimerPersonne("Lebrun");
		
		System.out.println("\nListe des personnes apres supp des Lebrun: ");
		liste = gp.listePersonnes();
		for (Personne personne : liste) {
			System.out.println(personne);
		}
	}

}
