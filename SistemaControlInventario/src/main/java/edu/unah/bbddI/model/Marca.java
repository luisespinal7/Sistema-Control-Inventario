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
	private int Marca;
	private String nombre_marca;
	
	@OneToMany(mappedBy="marca", fetch=FetchType.LAZY)
	private List<Producto> producto;
	
	public Marca(int marca, String nombre_marca) {
		super();
		Marca = marca;
		this.nombre_marca = nombre_marca;
	}

	public int getMarca() {
		return Marca;
	}

	public void setMarca(int marca) {
		Marca = marca;
	}

	public String getNombre_marca() {
		return nombre_marca;
	}

	public void setNombre_marca(String nombre_marca) {
		this.nombre_marca = nombre_marca;
	}
	
	

}
