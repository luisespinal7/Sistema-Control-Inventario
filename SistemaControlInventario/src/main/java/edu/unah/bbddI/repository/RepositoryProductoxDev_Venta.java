package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.IdProductoxDev_Venta;
import edu.unah.bbddI.model.ProductoxDev_Venta;

public interface RepositoryProductoxDev_Venta extends JpaRepository<ProductoxDev_Venta,IdProductoxDev_Venta>{
	
}
