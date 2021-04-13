package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Seccion_Producto;
import edu.unah.bbddI.repository.RepositorySeccion_Producto;

@Service
public class ServiceSeccion_Producto {
	@Autowired
	RepositorySeccion_Producto repositorySeccion_Producto;
	
	public void crear(Seccion_Producto seccion_Producto) {
		this.repositorySeccion_Producto.save(seccion_Producto);
	}
	
	public Seccion_Producto buscar(int Id_Seccion_Producto) {
		return this.repositorySeccion_Producto.findById(Id_Seccion_Producto);
	}
	
	public List<Seccion_Producto> obtenerTodos(){
		return this.repositorySeccion_Producto.findAll();
	}
}
