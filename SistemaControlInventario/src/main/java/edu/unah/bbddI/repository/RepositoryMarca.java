package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Marca;

public interface RepositoryMarca extends JpaRepository<Marca,Integer>{
	public Marca findById(int id);

}
