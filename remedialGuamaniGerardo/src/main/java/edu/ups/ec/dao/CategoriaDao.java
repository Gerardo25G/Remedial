package edu.ups.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.ups.ec.models.Autor;
import edu.ups.ec.models.Categoria;



@Stateless
public class CategoriaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Categoria> getListCategoria(){
		String jpql="Select p From Categoria p";
		
		Query q = em.createQuery(jpql, Categoria.class);
		return q.getResultList();
	}
	
	public Categoria read(int id) {
		Categoria categoria = em.find(Categoria.class, id);
		return categoria;
	}

}
