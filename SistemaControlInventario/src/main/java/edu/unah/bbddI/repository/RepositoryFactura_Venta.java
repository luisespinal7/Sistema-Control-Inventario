package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.Factura_Venta;

public interface RepositoryFactura_Venta extends JpaRepository<Factura_Venta,Integer>{
	public Factura_Venta findById(int id);

}
