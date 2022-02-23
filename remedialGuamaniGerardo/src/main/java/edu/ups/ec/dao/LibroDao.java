package edu.ups.ec.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.ups.ec.models.Libro;


@Stateless
public class LibroDao {
	
private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("remedialGuamaniGerardoPersistenceUnit");
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Libro libro) {
		em.persist(libro);
	}
	
	public void update(Libro libro) {
		em.merge(libro);
	}
	
	public Libro read(int id) {
		Libro libro = em.find(Libro.class, id);
		return libro;
	}
	
	public void delete(int id) {
		Libro libro = em.find(Libro.class, id);
		em.remove(libro);
	}
	
	public List<Libro> getList(){
		
		List<Libro> lista = new ArrayList<Libro>();
		String jpql="Select p From Libro p ";
		
		Query q = em.createQuery(jpql, Libro.class);
		lista = q.getResultList();
		
		for(Libro f: lista) {
			f.getAutores().size();
		}
		return lista;
	}
	
	
	public List<Libro> getListTrue(){
		
		List<Libro> lista = new ArrayList<Libro>();
		String jpql="Select p From Libro p Where disponible= false";
		
		Query q = em.createQuery(jpql, Libro.class);
		lista = q.getResultList();
		
		for(Libro f: lista) {
			f.getAutores().size();
		}
		return lista;
	}
	
	
	public List<Libro> getListXNombre(String filtro){
		
		String jpql="Select p From  Libro p Where nombre LIKE ?1";
		
		Query q = em.createQuery(jpql, Libro.class)
				.setParameter(1, filtro);
		return q.getResultList();
		
	}
	
	
//	private long getCountID(){
//		String jpql="Select Count(id) From Persona a ";
//		em=emf.createEntityManager();
//		
//		
//		long q = (long) em.createQuery(jpql).getSingleResult();
//		System.out.println("asdasd  "+ q);
//		
//		return q;
//	}
//	
//	
//	public List<Persona> getListPersonas(){
//		List<Persona> lista = new ArrayList<Persona>();
//		String jpql="Select p From Persona p";
//		
//		Query q = em.createQuery(jpql, Persona.class);
//		lista = q.getResultList();
//		
//		for(Persona f: lista) {
//			f.getFacturas().size();
//			f.getComentarios().size();
//		}
//		
//		return lista;
//	}

}
