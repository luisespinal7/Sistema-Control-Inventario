package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Telefono;
import edu.unah.bbddI.repository.RepositoryTelefono;

@Service
public class ServiceTelefono {
	@Autowired
	RepositoryTelefono repositoryTelefono;
	
	public void crear(Telefono Telefono) {
		this.repositoryTelefono.save(Telefono);
	}
	
	public Telefono buscar(int Id_Telefono) {
		return this.repositoryTelefono.findById(Id_Telefono);
	}
	
	public List<Telefono> obtenerTodos(){
		return this.repositoryTelefono.findAll();
	}
	
	public int buscarxNumero(String numero) {
		return this.repositoryTelefono.buscarxNumero(numero);
	}
}
