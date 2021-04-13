package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.IdTelxCliente;
import edu.unah.bbddI.model.TelxCliente;

public interface RepositoryTelxCliente extends JpaRepository<TelxCliente,IdTelxCliente>{

}
