package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Factura_Venta;
import edu.unah.bbddI.repository.RepositoryFactura_Venta;

@Service
public class ServiceFactura_Venta {
	@Autowired
	RepositoryFactura_Venta repositoryFactura_Venta;
	
	public void crear(Factura_Venta factura_Venta) {
		this.repositoryFactura_Venta.save(factura_Venta);
	}
	
	public Factura_Venta buscar(int Id_Factura_Venta) {
		return this.repositoryFactura_Venta.findById(Id_Factura_Venta);
	}
	
	public List<Factura_Venta> obtenerTodos(){
		return this.repositoryFactura_Venta.findAll();
	}
}
