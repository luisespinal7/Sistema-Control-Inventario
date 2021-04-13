package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente,Integer>{
	public Cliente findById(int id);
}
