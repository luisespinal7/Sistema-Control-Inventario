package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.IdTelxEmpleado;
import edu.unah.bbddI.model.TelxEmpleado;
import edu.unah.bbddI.repository.RepositoryTelxEmpleado;

@Service
public class ServiceTelxEmpleado {
	@Autowired
	RepositoryTelxEmpleado repositoryTelxEmpleado;
	
	public void crear(TelxEmpleado telxEmpleado) {
		this.repositoryTelxEmpleado.save(telxEmpleado);
	}
	
	public TelxEmpleado buscar(IdTelxEmpleado idTelxEmpleado) {
		return this.repositoryTelxEmpleado.getOne(idTelxEmpleado);
	}
	
	public List<TelxEmpleado> obtenerTodos(){
		return this.repositoryTelxEmpleado.findAll();
	}
}
