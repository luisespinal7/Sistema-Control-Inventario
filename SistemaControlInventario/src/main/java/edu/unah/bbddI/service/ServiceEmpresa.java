package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Empresa;
import edu.unah.bbddI.repository.RepositoryEmpresa;

@Service
public class ServiceEmpresa {
	@Autowired
	RepositoryEmpresa repositoryEmpresa;
	
	public void crear(Empresa empresa) {
		this.repositoryEmpresa.save(empresa);
	}
	
	public Empresa buscar(int Id_Empresa) {
		return this.repositoryEmpresa.findById(Id_Empresa);
	}
	
	public List<Empresa> obtenerTodos(){
		return this.repositoryEmpresa.findAll();
	}
}
