package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_PRODUCTO")
public class Tipo_Producto {
	@Id
	private int Id_Tipo_Producto;
	private String nombre_tipo_producto;
	
	@OneToMany(mappedBy="tipo_producto", fetch=FetchType.LAZY)
	private List<Producto> producto;
	
	public Tipo_Producto(int id_Tipo_Producto, String nombre_tipo_producto) {
		super();
		Id_Tipo_Producto = id_Tipo_Producto;
		this.nombre_tipo_producto = nombre_tipo_producto;
	}

	public int getId_Tipo_Producto() {
		return Id_Tipo_Producto;
	}

	public void setId_Tipo_Producto(int id_Tipo_Producto) {
		Id_Tipo_Producto = id_Tipo_Producto;
	}

	public String getNombre_tipo_producto() {
		return nombre_tipo_producto;
	}

	public void setNombre_tipo_producto(String nombre_tipo_producto) {
		this.nombre_tipo_producto = nombre_tipo_producto;
	}
	
	
	
}
