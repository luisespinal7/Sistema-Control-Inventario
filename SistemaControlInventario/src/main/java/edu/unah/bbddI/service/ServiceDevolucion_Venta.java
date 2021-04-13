package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Devolucion_Venta;
import edu.unah.bbddI.repository.RepositoryDevolucion_Venta;

@Service
public class ServiceDevolucion_Venta {
	@Autowired
	RepositoryDevolucion_Venta repositoryDevolucion_Venta;
	
	public void crear(Devolucion_Venta devolucion_Venta) {
		this.repositoryDevolucion_Venta.save(devolucion_Venta);
	}
	
	public Devolucion_Venta buscar(int Id_Devolucion_Venta) {
		return this.repositoryDevolucion_Venta.findById(Id_Devolucion_Venta);
	}
	
	public List<Devolucion_Venta> obtenerTodos(){
		return this.repositoryDevolucion_Venta.findAll();
	}
}
