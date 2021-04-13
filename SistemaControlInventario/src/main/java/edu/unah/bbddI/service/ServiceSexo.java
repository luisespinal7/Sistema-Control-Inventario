package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Sexo;
import edu.unah.bbddI.repository.RepositorySexo;

@Service
public class ServiceSexo {
	@Autowired
	RepositorySexo repositorySexo;
	
	public void crear(Sexo sexo) {
		this.repositorySexo.save(sexo);
	}
	
	public Sexo buscar(int Id_Sexo) {
		return this.repositorySexo.findById(Id_Sexo);
	}
	
	public List<Sexo> obtenerTodos(){
		return this.repositorySexo.findAll();
	}
}
