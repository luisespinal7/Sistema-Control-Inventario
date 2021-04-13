package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.IdProducto_Compra;
import edu.unah.bbddI.model.Producto_Compra;
import edu.unah.bbddI.repository.RepositoryProducto_Compra;

@Service
public class ServiceProducto_Compra {

	@Autowired
	RepositoryProducto_Compra repositoryProducto_Compra;
	
	public void crearProducto_Compra(Producto_Compra producto_Compra) {
		this.repositoryProducto_Compra.save(producto_Compra);
	}
	
	public Producto_Compra buscarProducto_Compra(IdProducto_Compra idProducto_Compra) {
		return this.repositoryProducto_Compra.getOne(idProducto_Compra);
	}
	
	public List<Producto_Compra> obtenerTodos(){
		return this.repositoryProducto_Compra.findAll();
	}
}
