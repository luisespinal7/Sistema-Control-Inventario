package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Descuento;
import edu.unah.bbddI.repository.RepositoryDescuento;

@Service
public class ServiceDescuento {
	@Autowired
	RepositoryDescuento repositoryDescuento;
	
	public void crear(Descuento descuento) {
		this.repositoryDescuento.save(descuento);
	}
	
	public Descuento buscar(int Id_Descuento) {
		return this.repositoryDescuento.findById(Id_Descuento);
	}
	
	public List<Descuento> obtenerTodos(){
		return this.repositoryDescuento.findAll();
	}
}
