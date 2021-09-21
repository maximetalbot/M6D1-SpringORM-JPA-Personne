package fr.eni.spring.dao;

import java.util.List;

import fr.eni.spring.bean.Personne;

public interface PersonneDAO {
	
	List<Personne> findAll();
	Personne findById(int id);
	Personne findLast();
	
	void add(Personne p);
	void update(Personne p);
	
	void delete(int id);
	void delete(String nom);
	void delete(Personne p);

}
