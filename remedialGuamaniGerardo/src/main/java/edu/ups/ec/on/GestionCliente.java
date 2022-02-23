package edu.ups.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.ups.ec.dao.CategoriaDao;
import edu.ups.ec.dao.ClienteDao;
import edu.ups.ec.models.Categoria;
import edu.ups.ec.models.Cliente;

@Stateless
public class GestionCliente {
	
	@Inject
	private ClienteDao daoCliente;
	
	public List<Cliente> getCategoria(){
		return daoCliente.getList();
	}
	
	public Cliente getCliente(String id) {
		Cliente cliente = daoCliente.read(id);
		return cliente;
	}

}
