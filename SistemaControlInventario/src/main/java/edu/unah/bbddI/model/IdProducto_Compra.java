package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdProducto_Compra implements Serializable{
	private int Id_Compra;
	private int Id_Producto;
	
	public IdProducto_Compra() {}

	public IdProducto_Compra(int id_Compra, int id_Producto) {
		super();
		Id_Compra = id_Compra;
		Id_Producto = id_Producto;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdProducto_Compra) {
			IdProducto_Compra tmpid = (IdProducto_Compra)obj;
			if(this.Id_Compra == tmpid.getId_Compra()
				&& this.Id_Producto == tmpid.getId_Producto()) {
				return true;
			}else 
				return false;
		}else return false;	
	}
	
	public int hashCode() {
		return (int) this.Id_Compra+this.Id_Producto;
	}

	public int getId_Compra() {
		return Id_Compra;
	}

	public void setId_Compra(int id_Compra) {
		Id_Compra = id_Compra;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}

}