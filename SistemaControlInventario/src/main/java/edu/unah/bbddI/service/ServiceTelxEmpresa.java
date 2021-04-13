package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.IdTelxEmpresa;
import edu.unah.bbddI.model.TelxEmpresa;
import edu.unah.bbddI.repository.RepositoryTelxEmpresa;

@Service
public class ServiceTelxEmpresa {
	@Autowired
	RepositoryTelxEmpresa repositoryTelxEmpresa;
	
	public void crear(TelxEmpresa telxEmpresa) {
		this.repositoryTelxEmpresa.save(telxEmpresa);
	}
	
	public TelxEmpresa buscar(IdTelxEmpresa idTelxEmpresa) {
		return this.repositoryTelxEmpresa.getOne(idTelxEmpresa);
	}
	
	public List<TelxEmpresa> obtenerTodos(){
		return this.repositoryTelxEmpresa.findAll();
	}
}
