package edu.unah.bbddI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.unah.bbddI.model.IdProductosProveedores;
import edu.unah.bbddI.model.ProductosProveedores;

public interface RepositoryProductosProveedores extends JpaRepository<ProductosProveedores,IdProductosProveedores>{

}
