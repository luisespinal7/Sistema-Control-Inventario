package edu.unah.bbddI.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.unah.bbddI.model.Telefono;

public interface RepositoryTelefono extends JpaRepository<Telefono,Integer>{
	public Telefono findById(int id);
	
	@Transactional
	@Query(value="select Id_Telefono from telefono where numero = ?1", nativeQuery=true)
	public int buscarxNumero(String numero);
}
