package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.IdProductoxDev_Compra;
import edu.unah.bbddI.model.ProductoxDev_Compra;
import edu.unah.bbddI.repository.RepositoryProductoxDev_Compra;

@Service
public class ServiceProductoxDev_Compra {
	@Autowired
	RepositoryProductoxDev_Compra repositoryProductoxDev_Compra;
	
	public void crearProductoxDev_Compra(ProductoxDev_Compra productoxDev_Compra) {
		this.repositoryProductoxDev_Compra.save(productoxDev_Compra);
	}
	
	public ProductoxDev_Compra buscarProductoxDev_Compra(IdProductoxDev_Compra idProductoxDev_Compra) {
		return this.repositoryProductoxDev_Compra.getOne(idProductoxDev_Compra);
	}
	
	public  List<ProductoxDev_Compra> obtenerTodos(){
		return this.repositoryProductoxDev_Compra.findAll();
	}

}
