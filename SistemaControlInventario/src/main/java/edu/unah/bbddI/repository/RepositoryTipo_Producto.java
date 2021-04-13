package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Tipo_Producto;

public interface RepositoryTipo_Producto extends JpaRepository<Tipo_Producto,Integer>{
	public Tipo_Producto findById(int id);

}
