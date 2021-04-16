package edu.unah.bbddI.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.unah.bbddI.model.Proveedor;

public interface RepositoryProveedor extends JpaRepository<Proveedor,Integer>{
	public Proveedor findById(int id);
	
	@Transactional
	@Query(value="select id_Proveedor from proveedor where nombre = ?1", nativeQuery=true)
	public int buscarxNombre(String nombre);

}
