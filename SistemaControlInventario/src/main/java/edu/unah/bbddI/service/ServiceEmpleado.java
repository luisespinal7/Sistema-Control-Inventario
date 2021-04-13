package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Empleado;
import edu.unah.bbddI.repository.RepositoryEmpleado;

@Service
public class ServiceEmpleado {
	@Autowired
	RepositoryEmpleado repositoryEmpleado;
	
	public void crear(Empleado empleado) {
		this.repositoryEmpleado.save(empleado);
	}
	
	public Empleado buscar(int Id_Empleado) {
		return this.repositoryEmpleado.findById(Id_Empleado);
	}
	
	public List<Empleado> obtenerTodos(){
		return this.repositoryEmpleado.findAll();
	}
}
