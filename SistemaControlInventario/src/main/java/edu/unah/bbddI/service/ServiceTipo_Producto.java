package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Tipo_Producto;
import edu.unah.bbddI.repository.RepositoryTipo_Producto;

@Service
public class ServiceTipo_Producto {
	@Autowired
	RepositoryTipo_Producto repositoryTipo_Producto;
	
	public void crear(Tipo_Producto tipo_Producto) {
		this.repositoryTipo_Producto.save(tipo_Producto);
	}
	
	public Tipo_Producto buscar(int Id_Tipo_Producto) {
		return this.repositoryTipo_Producto.findById(Id_Tipo_Producto);
	}
	
	public List<Tipo_Producto> obtenerTodos(){
		return this.repositoryTipo_Producto.findAll();
	}
	
	public boolean exist(int id) {
		return this.repositoryTipo_Producto.existsById(id);
	}
}
