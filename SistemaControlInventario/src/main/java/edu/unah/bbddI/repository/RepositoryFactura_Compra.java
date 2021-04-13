package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Factura_Compra;

public interface RepositoryFactura_Compra extends JpaRepository<Factura_Compra,Integer>{
	public Factura_Compra findById(int id);

}
