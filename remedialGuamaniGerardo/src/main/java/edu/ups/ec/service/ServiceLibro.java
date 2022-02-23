package edu.ups.ec.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.ups.ec.models.Libro;
import edu.ups.ec.on.GestionLibroOn;

@Path("libros")
public class ServiceLibro {
	
	@Inject
	private GestionLibroOn libroOn;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)//"application/json"
	public List<Libro> getProducto(){
		List<Libro> lista = libroOn.getLibro();
		return lista;
	}

}
