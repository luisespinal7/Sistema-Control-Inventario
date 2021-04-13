package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.IdProducto_Compra;
import edu.unah.bbddI.model.Producto_Compra;

public interface RepositoryProducto_Compra extends JpaRepository<Producto_Compra,IdProducto_Compra>{

}
