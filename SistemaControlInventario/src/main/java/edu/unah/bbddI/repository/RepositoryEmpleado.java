package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Empleado;

public interface RepositoryEmpleado extends JpaRepository<Empleado,Integer>{
	public Empleado findById(int id);

}
