package edu.ups.ec.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.ups.ec.models.Autor;
import edu.ups.ec.models.Categoria;
import edu.ups.ec.models.Libro;
import edu.ups.ec.on.GestionAutorOn;
import edu.ups.ec.on.GestionCategoriaOn;
import edu.ups.ec.on.GestionLibroOn;


@Named
@ViewScoped
public class LibroBean implements Serializable{
	
	@Inject
	private GestionLibroOn libroOn;
	
	@Inject
	private GestionCategoriaOn categoriaOn;
	
	@Inject
	private GestionAutorOn autorOn;
	
	private Libro libro;
	private List<Categoria> categorias;
	private List<Autor> autores;
	private Categoria categoria;
	private List<Autor> deta;
	private List<Libro> libros;
	private String filtro;
	
	
	
	private int dato;
	
	
	@PostConstruct
	public void init() {
		libro = new Libro(); 
		categorias=categoriaOn.getCategoria();
		autores=autorOn.getAutores();
		libros=libroOn.getLibro();
		
		
	}

	public GestionLibroOn getLibroOn() {
		return libroOn;
	}

	public void setLibroOn(GestionLibroOn libroOn) {
		this.libroOn = libroOn;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	
	
	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	

	public GestionCategoriaOn getCategoriaOn() {
		return categoriaOn;
	}

	public void setCategoriaOn(GestionCategoriaOn categoriaOn) {
		this.categoriaOn = categoriaOn;
	}

	public GestionAutorOn getAutorOn() {
		return autorOn;
	}

	public void setAutorOn(GestionAutorOn autorOn) {
		this.autorOn = autorOn;
	}

	public List<Autor> getDeta() {
		return deta;
	}

	public void setDeta(List<Autor> deta) {
		this.deta = deta;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String saveLibro() {
		libro.setAutores(deta);
		libro.setCategoria(categoriaOn.getCategoria(dato));
		
		libroOn.guardarLibro(libro);
		this.init();
		return "ListLibro";
	}

	
	public void llenarCombo() {
		
		for(int i=0; i<this.categorias.size(); i++) {
			System.out.println("LLeno" + this.categorias.get(i).getNombre());
		}
		
	}
	

public void addAutores(String id) {


		Autor autor = new Autor() ;
		autor=autorOn.getAutor(id);
			
		deta=libro.addDetalles(autor);
	
		}


public String buscarLibro() {
	libros = libroOn.getProductosPorNombre(filtro);
	return null;
}
}
