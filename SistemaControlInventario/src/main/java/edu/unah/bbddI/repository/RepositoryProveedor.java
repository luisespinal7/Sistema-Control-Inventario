package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Proveedor;

public interface RepositoryProveedor extends JpaRepository<Proveedor,Integer>{
	public Proveedor findById(int id);

}
