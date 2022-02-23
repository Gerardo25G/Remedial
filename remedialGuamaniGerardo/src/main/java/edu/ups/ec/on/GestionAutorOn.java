package edu.ups.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.ups.ec.dao.AutorDao;
import edu.ups.ec.models.Autor;
import edu.ups.ec.models.Libro;

@Stateless
public class GestionAutorOn {

	
	@Inject
	private AutorDao daoAutor;
	
	public List<Autor> getAutores(){
		return daoAutor.getListAutores();
	}
	
	
	public Autor getAutor(String id) {
		Autor autor = daoAutor.read(id);
		return autor;
	}
}
