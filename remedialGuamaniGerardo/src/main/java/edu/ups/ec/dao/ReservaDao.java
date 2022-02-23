package edu.ups.ec.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.ups.ec.models.Reserva;



@Stateless
public class ReservaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Reserva reserva) {
		em.persist(reserva);
	}
	
	public void update(Reserva reserva) {
		em.merge(reserva);
	}
	
	public Reserva read(int id) {
		Reserva reserva = em.find(Reserva.class, id);
		return reserva;
	}
	
	public void delete(int id) {
		Reserva reserva = em.find(Reserva.class, id);
		em.remove(reserva);
	}
	
	public List<Reserva> getList(){
		
		List<Reserva> lista = new ArrayList<Reserva>();
		String jpql="Select p From Reserva p";
		
		Query q = em.createQuery(jpql, Reserva.class);
		lista = q.getResultList();
		
		for(Reserva f: lista) {
			f.getLibros().size();
		}
		return lista;
	}
	
	

}
