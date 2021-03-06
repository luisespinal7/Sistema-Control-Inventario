package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Producto;
import edu.unah.bbddI.repository.RepositoryProducto;

@Service
public class ServiceProducto {
	@Autowired
	RepositoryProducto repositoryProducto;
	
	public void crear(Producto producto) {
		this.repositoryProducto.save(producto);
	}
	
	public Producto buscar(int Id_Producto) {
		return this.repositoryProducto.findById(Id_Producto);
	}
	
	public List<Producto> obtenerTodos(){
		return this.repositoryProducto.findAll();
	}
	
	public Producto eliminar(int id) {
		Producto producto = this.buscar(id);
		this.repositoryProducto.deleteById(id);
		return producto;
	}
	
	public boolean exist(int id) {
		return this.repositoryProducto.existsById(id);
	}
	
}
