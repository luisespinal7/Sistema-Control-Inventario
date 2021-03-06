package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.IdProductosProveedores;
import edu.unah.bbddI.model.ProductosProveedores;
import edu.unah.bbddI.repository.RepositoryProductosProveedores;

@Service
public class ServiceProductosProveedores {
	@Autowired
	RepositoryProductosProveedores repositoryProductosProveedores;
	
	public void crearProductosProveedores(ProductosProveedores productosProveedores) {
		this.repositoryProductosProveedores.save(productosProveedores);
	}
	
	public ProductosProveedores buscarProductosProveedores(IdProductosProveedores idProductosProveedores) {
		return this.repositoryProductosProveedores.getOne(idProductosProveedores);
	}
	
	public List<ProductosProveedores> obtenerTodosProductosProveedores(){
		return this.repositoryProductosProveedores.findAll();
	}
	
	public void eliminar(ProductosProveedores productosProveedores) {
		this.repositoryProductosProveedores.delete(productosProveedores);;
	}
}
