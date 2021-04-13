package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.IdTelxEmpresa;
import edu.unah.bbddI.model.TelxEmpresa;

public interface RepositoryTelxEmpresa extends JpaRepository<TelxEmpresa,IdTelxEmpresa>{

}
