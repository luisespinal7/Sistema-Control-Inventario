package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.IdTelxProveedor;
import edu.unah.bbddI.model.TelxProveedor;

public interface RepositoryTelxProveedor extends JpaRepository<TelxProveedor,IdTelxProveedor>{

}
