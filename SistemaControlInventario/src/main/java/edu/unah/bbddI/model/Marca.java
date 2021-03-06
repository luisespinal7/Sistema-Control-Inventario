package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "MARCA")
public class Marca {
	@Id
	private int Id_Marca;
	private String nombre_marca;
	
	@OneToMany(mappedBy="marca", fetch=FetchType.LAZY)
	private List<Producto> producto;
	
	public Marca() {}
	
	public Marca(int marca, String nombre_marca) {
		super();
		Id_Marca = marca;
		this.nombre_marca = nombre_marca;
	}

	
	

	public int getId_Marca() {
		return Id_Marca;
	}

	public void setId_Marca(int id_Marca) {
		Id_Marca = id_Marca;
	}

	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}
	
	

}
