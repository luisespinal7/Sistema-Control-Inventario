package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.IdTelxCliente;
import edu.unah.bbddI.model.TelxCliente;
import edu.unah.bbddI.repository.RepositoryTelxCliente;

@Service
public class ServiceTelxCliente {
	
	@Autowired
	RepositoryTelxCliente repositoryTelxCliente;
	
	public void crear(TelxCliente telxCliente) {
		this.repositoryTelxCliente.save(telxCliente);
	}
	
	public TelxCliente buscar(IdTelxCliente idTelxCliente) {
		return this.repositoryTelxCliente.getOne(idTelxCliente);
	}
	
	public List<TelxCliente> obtenerTodos(){
		return this.repositoryTelxCliente.findAll();
	}
}
