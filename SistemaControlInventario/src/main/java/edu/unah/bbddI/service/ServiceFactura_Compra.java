package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Factura_Compra;
import edu.unah.bbddI.repository.RepositoryFactura_Compra;

@Service
public class ServiceFactura_Compra {
	@Autowired
	RepositoryFactura_Compra repositoryFactura_Compra;
	
	public void crear(Factura_Compra factura_Compra) {
		this.repositoryFactura_Compra.save(factura_Compra);
	}
	
	public Factura_Compra buscar(int Id_Factura_Compra) {
		return this.repositoryFactura_Compra.findById(Id_Factura_Compra);
	}
	
	public List<Factura_Compra> obtenerTodos(){
		return this.repositoryFactura_Compra.findAll();
	}
}
