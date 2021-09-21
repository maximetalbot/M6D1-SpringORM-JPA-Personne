package fr.eni.spring.dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import fr.eni.spring.bean.Personne;

@Repository
public class PersonneDAOImpl implements PersonneDAO {

	@PersistenceContext
	EntityManager em;
	
	public PersonneDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<Personne> findAll() {
		return em
				.createQuery("SELECT p FROM Personne p", Personne.class)
				.getResultList();
	}

	public Personne findById(int id) {
		return em.find(Personne.class, id);
	}

	public Personne findLast() {
		return findById(getLastId());
	}
	
	private int getLastId() {
		return em
				.createQuery("SELECT max(p.id) FROM Personne p", Integer.class)
				.getSingleResult();
	}

	@Transactional
	public void add(Personne p) {
		em.persist(p);
	}

	@Transactional
	public void update(Personne p) {
		em.merge(p);		
	}

	@Transactional
	public void delete(int id) {
		Personne p = findById(id);
		if (p != null)
			em.remove(p);		
	}

	@Transactional
	public void delete(String nom) {
		em
			.createQuery("DELETE FROM Personne p WHERE p.nom = :param")
			.setParameter("param", nom)
			.executeUpdate();
	}

	@Transactional
	public void delete(Personne p) {
		delete(p.getId());
	}

}
