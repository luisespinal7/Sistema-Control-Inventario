package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Pago;

public interface RepositoryPago extends JpaRepository<Pago,Integer>{
	public Pago findById(int id);

}
