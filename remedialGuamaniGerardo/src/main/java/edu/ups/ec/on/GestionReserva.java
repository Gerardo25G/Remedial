package edu.ups.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.ups.ec.dao.LibroDao;
import edu.ups.ec.dao.ReservaDao;
import edu.ups.ec.models.Libro;
import edu.ups.ec.models.Reserva;

@Stateless
public class GestionReserva {
	
	@Inject
	ReservaDao daoreserva;
	
	public void guardarReserva(Reserva reserva) {
		
		Reserva l = daoreserva.read(reserva.getId());
		
		if(l==null)
			daoreserva.insert(reserva);
		else
			daoreserva.update(reserva);

	}
	
	public List<Reserva> getReservas(){
		return daoreserva.getList();
	}

	public Reserva getReserva(int id) {
		Reserva reserva = daoreserva.read(id);
		return reserva;
	}
	
	public String eliminar(int id) {
		daoreserva.delete(id);
		return "Eliminado";
	}

}

