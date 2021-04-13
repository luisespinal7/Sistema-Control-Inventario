package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Cuota;

public interface RepositoryCuota extends JpaRepository<Cuota,Integer>{
	public Cuota findById(int id);
}
