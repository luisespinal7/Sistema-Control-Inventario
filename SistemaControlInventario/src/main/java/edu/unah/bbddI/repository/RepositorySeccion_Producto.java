package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Seccion_Producto;

public interface RepositorySeccion_Producto extends JpaRepository<Seccion_Producto,Integer>{
	public Seccion_Producto findById(int id);

}
