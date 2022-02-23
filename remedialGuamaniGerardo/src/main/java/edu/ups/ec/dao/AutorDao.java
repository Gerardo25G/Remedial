package edu.ups.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.ups.ec.models.Autor;
import edu.ups.ec.models.Libro;



@Stateless
public class AutorDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Autor> getListAutores(){
		String jpql="Select p From Autor p";
		
		Query q = em.createQuery(jpql, Autor.class);
		return q.getResultList();
	}
	
	public Autor read(String id) {
		Autor autor = em.find(Autor.class, id);
		return autor;
	}

}
