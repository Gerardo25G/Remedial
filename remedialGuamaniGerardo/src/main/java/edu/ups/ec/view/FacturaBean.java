package edu.ups.ec.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.ups.ec.models.Cliente;
import edu.ups.ec.models.Libro;
import edu.ups.ec.models.Reserva;
import edu.ups.ec.on.GestionAutorOn;
import edu.ups.ec.on.GestionCategoriaOn;
import edu.ups.ec.on.GestionCliente;
import edu.ups.ec.on.GestionLibroOn;
import edu.ups.ec.on.GestionReserva;

@Named
@ViewScoped
public class FacturaBean implements Serializable{
	
	private Reserva reserva;
	private String dato;
	private Cliente cliente;
	
	private List<Libro> libros;
	
	@Inject
	private GestionLibroOn libroOn;
	
	@Inject
	private GestionCliente clienteOn;
	
	@Inject
	private GestionAutorOn autorOn;
	
	@Inject
	private GestionReserva reservaOn;
	
	
	private List<Libro> deta;
	
	private String filtro;
	
	
	@PostConstruct
	public void init() {
		reserva = new Reserva(); 
		libros=libroOn.getLibroTrue();
	}


	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	public List<Libro> getLibros() {
		return libros;
	}


	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public GestionCliente getClienteOn() {
		return clienteOn;
	}


	public void setClienteOn(GestionCliente clienteOn) {
		this.clienteOn = clienteOn;
	}


	public List<Libro> getDeta() {
		return deta;
	}


	public void setDeta(List<Libro> deta) {
		this.deta = deta;
	}


	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


	public GestionLibroOn getLibroOn() {
		return libroOn;
	}


	public void setLibroOn(GestionLibroOn libroOn) {
		this.libroOn = libroOn;
	}




	public GestionAutorOn getAutorOn() {
		return autorOn;
	}


	public void setAutorOn(GestionAutorOn autorOn) {
		this.autorOn = autorOn;
	}


	public String getDato() {
		return dato;
	}


	public void setDato(String dato) {
		this.dato = dato;
	}
	
	
	
	
	public String guardar() {
		cliente = new Cliente();
		cliente=clienteOn.getCliente(dato);
		
		reserva.setCliente(cliente);
		
		reservaOn.guardarReserva(reserva);
		
		
		
			for(int i=0; i<this.deta.size(); i++ ) {

				Libro libro = new Libro();
				libro=libroOn.getLibro(deta.get(i).getId());
				libro.setDisponible(true);
				libroOn.guardarLibro(libro);
			}
		

		
		
	return "ListLibro";
		
	}
	
	
	public void addDetalles(int id) {

		Libro libro = new Libro() ;

		libro=libroOn.getLibro(id);

		deta=reserva.addDetalles(libro);


		//return null;
	}
	
	
	public String buscarLibro() {
		libros = libroOn.getProductosPorNombre(filtro);
		return null;
	}
	

}
