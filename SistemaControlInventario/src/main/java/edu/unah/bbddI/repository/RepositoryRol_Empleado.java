package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Rol_Empleado;

public interface RepositoryRol_Empleado extends JpaRepository<Rol_Empleado,Integer>{
	public Rol_Empleado findById(int id);

}
