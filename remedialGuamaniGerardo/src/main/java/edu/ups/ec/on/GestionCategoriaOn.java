package edu.ups.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.ups.ec.dao.CategoriaDao;
import edu.ups.ec.models.Autor;
import edu.ups.ec.models.Categoria;
import edu.ups.ec.models.Libro;

@Stateless
public class GestionCategoriaOn {
	
	@Inject
	private CategoriaDao daocategoria;
	
	public List<Categoria> getCategoria(){
		return daocategoria.getListCategoria();
	}
	
	public Categoria getCategoria(int id) {
		Categoria categoria = daocategoria.read(id);
		return categoria;
	}

}
