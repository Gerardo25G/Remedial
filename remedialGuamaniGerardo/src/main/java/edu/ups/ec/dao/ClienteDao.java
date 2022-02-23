package edu.ups.ec.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.ups.ec.models.Cliente;


@Stateless
public class ClienteDao {
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}
	
	public Cliente read(String id) {
		Cliente cliente = em.find(Cliente.class, id);
		return cliente;
	}
	
	public void delete(String id) {
		Cliente cliente = em.find(Cliente.class, id);
		em.remove(cliente);
	}
	
	public List<Cliente> getList(){
		
		List<Cliente> lista = new ArrayList<Cliente>();
		String jpql="Select p From Cliente p";
		
		Query q = em.createQuery(jpql, Cliente.class);
		lista = q.getResultList();
		
		return lista;
	}

}
