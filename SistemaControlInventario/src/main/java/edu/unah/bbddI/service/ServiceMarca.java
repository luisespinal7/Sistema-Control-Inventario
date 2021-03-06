package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Marca;
import edu.unah.bbddI.repository.RepositoryMarca;

@Service
public class ServiceMarca {
	@Autowired
	RepositoryMarca repositoryMarca;
	
	public void crear(Marca marca) {
		this.repositoryMarca.save(marca);
	}
	
	public Marca buscar(int Id_Marca) {
		return this.repositoryMarca.findById(Id_Marca);
	}
	
	public List<Marca> obtenerTodos(){
		return this.repositoryMarca.findAll();
	}
	
	public boolean exist(int id) {
		return this.repositoryMarca.existsById(id);
	}
}
