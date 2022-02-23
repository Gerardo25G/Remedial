package edu.ups.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.ups.ec.dao.LibroDao;
import edu.ups.ec.models.Libro;


@Stateless
public class GestionLibroOn {
	
	@Inject
	LibroDao daolibro;
	
	public void guardarLibro(Libro libro) {
		
		Libro l = daolibro.read(libro.getId());
		
		if(l==null)
			daolibro.insert(libro);
		else
			daolibro.update(libro);

	}
	
	public List<Libro> getLibro(){
		return daolibro.getList();
	}
	
	public List<Libro> getLibroTrue(){
		return daolibro.getListTrue();
	}
	
	public Libro getLibro(int id) {
		Libro libro = daolibro.read(id);
		return libro;
	}
	
	public String eliminar(int id) {
		daolibro.delete(id);
		return "Eliminado";
	}
	
	public List<Libro> getProductosPorNombre(String filtro){
		return daolibro.getListXNombre(filtro);
	}
	
//	public List<Libro> getLibroList(){
//		
//		return daolibro.getListPersonas();
//	}

}
