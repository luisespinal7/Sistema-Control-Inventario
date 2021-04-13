package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Descuento;

public interface RepositoryDescuento extends JpaRepository<Descuento,Integer>{
	public Descuento findById(int id);
}
