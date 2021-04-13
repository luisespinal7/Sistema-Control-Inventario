package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Rol_Empleado;
import edu.unah.bbddI.repository.RepositoryRol_Empleado;

@Service
public class ServiceRol_Empleado {
	@Autowired
	RepositoryRol_Empleado repositoryRol_Empleado;
	
	public void crear(Rol_Empleado rol_Empleado) {
		this.repositoryRol_Empleado.save(rol_Empleado);
	}
	
	public Rol_Empleado buscar(int Id_Rol_Empleado) {
		return this.repositoryRol_Empleado.findById(Id_Rol_Empleado);
	}
	
	public List<Rol_Empleado> obtenerTodos(){
		return this.repositoryRol_Empleado.findAll();
	}
}
