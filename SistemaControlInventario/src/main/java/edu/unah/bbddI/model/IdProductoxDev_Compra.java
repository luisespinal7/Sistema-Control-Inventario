package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdProductoxDev_Compra implements Serializable {
	private int Id_Dev_Compra;
	private int Id_Producto;
	
	public IdProductoxDev_Compra(int id_Dev_Compra, int id_Producto) {
		super();
		Id_Dev_Compra = id_Dev_Compra;
		Id_Producto = id_Producto;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdProductoxDev_Compra) {
			IdProductoxDev_Compra tmpid = (IdProductoxDev_Compra)obj;
			if(this.Id_Dev_Compra == tmpid.getId_Dev_Compra()
				&& this.Id_Producto == tmpid.getId_Producto()) {
				return true;
			}else 
				return false;
		}else return false;	
	}
	
	public int hashCode() {
		return (int) this.Id_Dev_Compra+this.Id_Producto;
	}
	
	public int getId_Dev_Compra() {
		return Id_Dev_Compra;
	}

	public void setId_Dev_Compra(int id_Dev_Compra) {
		Id_Dev_Compra = id_Dev_Compra;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}
	
	
	
	

}
