package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.IdProducto_Venta;
import edu.unah.bbddI.model.Producto_Venta;
import edu.unah.bbddI.repository.RepositoryProducto_Venta;

@Service
public class ServiceProducto_Venta {
	
	@Autowired
	RepositoryProducto_Venta repositoryProducto_Venta;

	public void crearProducto_Venta(Producto_Venta producto_Venta) {
		this.repositoryProducto_Venta.save(producto_Venta);
	}
	
	public Producto_Venta buscarProducto_Venta(IdProducto_Venta idProducto_Venta) {
		return this.repositoryProducto_Venta.getOne(idProducto_Venta);
	}
	
	public List<Producto_Venta> obtenerTodos(){
		return this.repositoryProducto_Venta.findAll();
	}
}
