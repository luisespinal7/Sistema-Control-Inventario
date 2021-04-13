package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Producto;

public interface RepositoryProducto extends JpaRepository<Producto,Integer>{
	public Producto findById(int id);

}
