package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Tipo_Pago;
import edu.unah.bbddI.repository.RepositoryTipo_Pago;

@Service
public class ServiceTipo_Pago {
	@Autowired
	RepositoryTipo_Pago repositoryTipo_Pago;
	
	public void crear(Tipo_Pago Tipo_Pago) {
		this.repositoryTipo_Pago.save(Tipo_Pago);
	}
	
	public Tipo_Pago buscar(int Id_Tipo_Pago) {
		return this.repositoryTipo_Pago.findById(Id_Tipo_Pago);
	}
	
	public List<Tipo_Pago> obtenerTodos(){
		return this.repositoryTipo_Pago.findAll();
	}
}
