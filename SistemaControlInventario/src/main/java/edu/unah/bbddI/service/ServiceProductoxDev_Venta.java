package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.IdProductoxDev_Venta;
import edu.unah.bbddI.model.ProductoxDev_Venta;
import edu.unah.bbddI.repository.RepositoryProductoxDev_Venta;

@Service
public class ServiceProductoxDev_Venta {
	@Autowired
	RepositoryProductoxDev_Venta repositoryProductoxDev_Venta;
	
	public void crearProductoxDev_Venta(ProductoxDev_Venta productoxDev_Venta) {
		this.repositoryProductoxDev_Venta.save(productoxDev_Venta);
	}
	
	public ProductoxDev_Venta buscarProductoxDev_Venta(IdProductoxDev_Venta idProductoxDev_Venta) {
		return this.repositoryProductoxDev_Venta.getOne(idProductoxDev_Venta);
	}
	
	public List<ProductoxDev_Venta> obtenerTodos(){
		return this.repositoryProductoxDev_Venta.findAll();
	}

}
