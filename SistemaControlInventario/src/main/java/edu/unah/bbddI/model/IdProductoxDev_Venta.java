package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdProductoxDev_Venta implements Serializable{
	private int Id_Dev_Venta;
	private int Id_Producto;
	
	public IdProductoxDev_Venta(int id_Dev_Venta, int id_Producto) {
		super();
		Id_Dev_Venta = id_Dev_Venta;
		Id_Producto = id_Producto;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdProductoxDev_Venta) {
			IdProductoxDev_Venta tmpid = (IdProductoxDev_Venta)obj;
			if(this.Id_Dev_Venta == tmpid.getId_Dev_Venta()
				&& this.Id_Producto == tmpid.getId_Producto()) {
				return true;
			}else 
				return false;
		}else return false;	
	}

	public int hashCode() {
		return (int) this.Id_Dev_Venta+this.Id_Producto;
	}
	
	public int getId_Dev_Venta() {
		return Id_Dev_Venta;
	}

	public void setId_Dev_Int(int id_Dev_Venta) {
		Id_Dev_Venta = id_Dev_Venta;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}
	
	
	
	
}
