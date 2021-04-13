package edu.unah.bbddI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.unah.bbddI.model.Cuota;
import edu.unah.bbddI.repository.RepositoryCuota;

@Service
public class ServiceCuota {
	@Autowired
	RepositoryCuota repositoryCuota;
	
	public void crear(Cuota cuota) {
		this.repositoryCuota.save(cuota);
	}
	
	public Cuota buscar(int Id_Cuota) {
		return this.repositoryCuota.findById(Id_Cuota);
	}
	
	public List<Cuota> obtenerTodos(){
		return this.repositoryCuota.findAll();
	}
}
