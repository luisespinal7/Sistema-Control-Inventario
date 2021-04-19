package edu.unah.bbddI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Proveedor;
import edu.unah.bbddI.model.Telefono;
import edu.unah.bbddI.repository.RepositoryProveedor;

@Service
public class ServiceProveedor {
	@Autowired
	RepositoryProveedor repositoryProveedor;
	
	public void crear(Proveedor proveedor) {
		this.repositoryProveedor.save(proveedor);
	}
	
	/*public void actualizar(Proveedor proveedor) {
		this.repositoryProveedor.
	}*/
	
	
	public Proveedor buscar(int Id_Proveedor) {
		return this.repositoryProveedor.findById(Id_Proveedor);
	}
	
	public List<Proveedor> obtenerTodos(){
		return this.repositoryProveedor.findAll();
	}
	
	public int buscarxNombre(String nombre) {
		return this.repositoryProveedor.buscarxNombre(nombre);
	}
	
	public boolean exist(int idProveedor) {
		return this.repositoryProveedor.existsById(idProveedor);
	}
	
	public List<Proveedor> listarProveedores(){
		List<Proveedor> proveedores = new ArrayList<Proveedor>();
		for(Proveedor proveedor: this.repositoryProveedor.findAll()) {
			proveedores.add(proveedor);
		}
		return proveedores;
	}
	
}


