package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Sexo;

public interface RepositorySexo extends JpaRepository<Sexo,Integer>{
	public Sexo findById(int id);

}
