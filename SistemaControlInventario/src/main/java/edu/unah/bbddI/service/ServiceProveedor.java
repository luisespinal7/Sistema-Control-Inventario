package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Proveedor;
import edu.unah.bbddI.repository.RepositoryProveedor;

@Service
public class ServiceProveedor {
	@Autowired
	RepositoryProveedor repositoryProveedor;
	
	public void crear(Proveedor proveedor) {
		this.repositoryProveedor.save(proveedor);
	}
	
	public Proveedor buscar(int Id_Proveedor) {
		return this.repositoryProveedor.findById(Id_Proveedor);
	}
	
	public List<Proveedor> obtenerTodos(){
		return this.repositoryProveedor.findAll();
	}
}