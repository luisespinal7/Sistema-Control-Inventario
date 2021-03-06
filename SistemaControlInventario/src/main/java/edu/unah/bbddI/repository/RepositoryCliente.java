package edu.unah.bbddI.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.unah.bbddI.model.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente,Integer>{
	public Cliente findById(int id);
	
	@Transactional
	@Query(value="select id_Cliente from cliente where p_nombre = ?1", nativeQuery=true)
	public int buscarxNombre(String nombre);
}
