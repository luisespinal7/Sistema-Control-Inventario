package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Tipo_Pago;

public interface RepositoryTipo_Pago extends JpaRepository<Tipo_Pago,Integer>{
	public Tipo_Pago findById(int id);

}
