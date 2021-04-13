package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Telefono;

public interface RepositoryTelefono extends JpaRepository<Telefono,Integer>{
	public Telefono findById(int id);

}
