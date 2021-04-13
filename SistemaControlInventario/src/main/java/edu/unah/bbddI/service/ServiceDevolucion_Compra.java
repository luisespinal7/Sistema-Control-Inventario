package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Devolucion_Compra;
import edu.unah.bbddI.repository.RepositoryDevolucion_Compra;

@Service
public class ServiceDevolucion_Compra {
	@Autowired
	RepositoryDevolucion_Compra repositoryDevolucion_Compra;
	
	public void crear(Devolucion_Compra devolucion_Compra) {
		this.repositoryDevolucion_Compra.save(devolucion_Compra);
	}
	
	public Devolucion_Compra buscar(int Id_Devolucion_Compra) {
		return this.repositoryDevolucion_Compra.findById(Id_Devolucion_Compra);
	}
	
	public List<Devolucion_Compra> obtenerTodos(){
		return this.repositoryDevolucion_Compra.findAll();
	}
}
