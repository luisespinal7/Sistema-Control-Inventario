package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Cliente;
import edu.unah.bbddI.repository.RepositoryCliente;

@Service
public class ServiceCliente {
	@Autowired
	RepositoryCliente repositoryCliente;
	
	public void crearCliente(Cliente cliente) {
		this.repositoryCliente.save(cliente);
	}
	
	public Cliente buscarCliente(int Id_Cliente){
		return this.repositoryCliente.findById(Id_Cliente);
	}
	
	public List<Cliente> obtenerTodos(){
		return this.repositoryCliente.findAll();
	}
	
	public int buscarxNombre(String nombre) {
		return this.repositoryCliente.buscarxNombre(nombre);
	}
	
	public boolean exist(int id) {
		return this.repositoryCliente.existsById(id);
	}


}
