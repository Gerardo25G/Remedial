package edu.ups.ec.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categoria {
	
	private static final long serialVersionUID=1L;
	
	@Id
	private int id;
	private String nombre;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
