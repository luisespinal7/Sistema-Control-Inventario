package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Pago;
import edu.unah.bbddI.repository.RepositoryPago;

@Service
public class ServicePago {
	@Autowired
	RepositoryPago repositoryPago;
	
	public void crear(Pago pago) {
		this.repositoryPago.save(pago);
	}
	
	public Pago buscar(int Id_Pago) {
		return this.repositoryPago.findById(Id_Pago);
	}
	
	public List<Pago> obtenerTodos(){
		return this.repositoryPago.findAll();
	}
}
