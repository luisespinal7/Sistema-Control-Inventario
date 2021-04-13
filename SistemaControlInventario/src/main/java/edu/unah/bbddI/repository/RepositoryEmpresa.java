package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Empresa;

public interface RepositoryEmpresa extends JpaRepository<Empresa,Integer>{
	public Empresa findById(int id);

}
