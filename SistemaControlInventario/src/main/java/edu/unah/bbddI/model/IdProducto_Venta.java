package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdProducto_Venta implements Serializable{
	private int Id_Venta;
	private int Id_Producto;
	
	public IdProducto_Venta(int id_Venta, int id_Producto) {
		super();
		Id_Venta = id_Venta;
		Id_Producto = id_Producto;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdProducto_Venta) {
			IdProducto_Venta tmpid = (IdProducto_Venta)obj;
			if(this.Id_Venta == tmpid.getId_Venta()
				&& this.Id_Producto == tmpid.getId_Producto()) {
				return true;
			}else 
				return false;
		}else return false;	
	}

	public int hashCode() {
		return (int) this.Id_Venta+this.Id_Producto;
	}
	
	public int getId_Venta() {
		return Id_Venta;
	}

	public void setId_Venta(int id_Venta) {
		Id_Venta = id_Venta;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}
	
	

}
