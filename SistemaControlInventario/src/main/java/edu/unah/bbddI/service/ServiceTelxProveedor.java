package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.IdTelxProveedor;
import edu.unah.bbddI.model.TelxProveedor;
import edu.unah.bbddI.repository.RepositoryTelxProveedor;

@Service
public class ServiceTelxProveedor {
	@Autowired
	RepositoryTelxProveedor repositoryTelxProveedor;
	
	public void crear(TelxProveedor telxProveedor) {
		this.repositoryTelxProveedor.save(telxProveedor);
	}
	
	public TelxProveedor buscar(IdTelxProveedor idTelxProveedor) {
		return this.repositoryTelxProveedor.getOne(idTelxProveedor);
	}
	
	public List<TelxProveedor> obtenerTodos(){
		return this.repositoryTelxProveedor.findAll();
	}
}
