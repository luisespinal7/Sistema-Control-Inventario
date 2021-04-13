package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.IdTelxEmpleado;
import edu.unah.bbddI.model.TelxEmpleado;

public interface RepositoryTelxEmpleado extends JpaRepository<TelxEmpleado,IdTelxEmpleado>{

}
