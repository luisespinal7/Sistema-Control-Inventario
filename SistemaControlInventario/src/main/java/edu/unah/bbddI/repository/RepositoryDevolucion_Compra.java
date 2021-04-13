package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Devolucion_Compra;

public interface RepositoryDevolucion_Compra extends JpaRepository<Devolucion_Compra,Integer>{
	public Devolucion_Compra findById(int id);
}
