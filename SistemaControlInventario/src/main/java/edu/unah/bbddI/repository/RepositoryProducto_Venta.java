package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.IdProducto_Venta;
import edu.unah.bbddI.model.Producto_Venta;

public interface RepositoryProducto_Venta extends JpaRepository<Producto_Venta,IdProducto_Venta>{

}
