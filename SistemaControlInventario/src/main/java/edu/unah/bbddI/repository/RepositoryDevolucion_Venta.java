package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Devolucion_Venta;

public interface RepositoryDevolucion_Venta extends JpaRepository<Devolucion_Venta,Integer>{
	public Devolucion_Venta findById(int id);

}
