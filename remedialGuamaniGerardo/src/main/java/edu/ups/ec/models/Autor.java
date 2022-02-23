package edu.ups.ec.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Autor {
	
	private static final long serialVersionUID=1L;
	
	@Id
	private String cedula;
	private String nombre;
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
