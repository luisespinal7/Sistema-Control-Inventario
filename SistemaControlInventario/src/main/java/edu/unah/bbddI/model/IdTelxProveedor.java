package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdTelxProveedor implements Serializable{
	private int Id_Telefono;
	private int Id_Proveedor;
	
	public IdTelxProveedor(int id_Telefono, int id_Proveedor) {
		super();
		Id_Telefono = id_Telefono;
		Id_Proveedor = id_Proveedor;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdTelxProveedor) {
			IdTelxProveedor tmpid = (IdTelxProveedor)obj;
			if(this.Id_Telefono == tmpid.getId_Telefono()
				&& this.Id_Proveedor == tmpid.getId_Proveedor()) {
				return true;
			}else 
				return false;
		}else return false;	
	}
	
	public int hashCode() {
		return (int) this.Id_Telefono+this.Id_Proveedor;
	}
	
	public int getId_Telefono() {
		return Id_Telefono;
	}

	public void setId_Telefono(int id_Telefono) {
		Id_Telefono = id_Telefono;
	}

	public int getId_Proveedor() {
		return Id_Proveedor;
	}

	public void setId_Proveedor(int id_Proveedor) {
		Id_Proveedor = id_Proveedor;
	}	
	
}