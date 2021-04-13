package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SECCION_PRODUCTO")
public class Seccion_Producto {
	@Id
	private int Id_Seccion_Producto;
	private String nombre_seccion_producto;
	
	@OneToMany(mappedBy="seccion_producto", fetch=FetchType.LAZY)
	private List<Producto> producto;
	
	public Seccion_Producto(int id_Seccion_Producto, String nombre_seccion_producto) {
		super();
		Id_Seccion_Producto = id_Seccion_Producto;
		this.nombre_seccion_producto = nombre_seccion_producto;
	}

	public int getId_Seccion_Producto() {
		return Id_Seccion_Producto;
	}

	public void setId_Seccion_Producto(int id_Seccion_Producto) {
		Id_Seccion_Producto = id_Seccion_Producto;
	}

	public String getNombre_seccion_producto() {
		return nombre_seccion_producto;
	}

	public void setNombre_seccion_producto(String nombre_seccion_producto) {
		this.nombre_seccion_producto = nombre_seccion_producto;
	}

	
}
