package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdProductosProveedores implements Serializable{
	private int Id_Producto;
	private int Id_Proveedor;
	
	public IdProductosProveedores() {}

	public IdProductosProveedores(int id_Producto, int id_Proveedor) {
		super();
		Id_Producto = id_Producto;
		Id_Proveedor = id_Proveedor;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdProductosProveedores) {
			IdProductosProveedores tmpid = (IdProductosProveedores)obj;
			if(this.Id_Producto == tmpid.getId_Producto()
				&& this.Id_Proveedor == tmpid.getId_Proveedor()) {
				return true;
			}else 
				return false;
		}else return false;	
	}
	
	public int hashCode() {
		return (int) this.Id_Proveedor+this.Id_Producto;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}

	public int getId_Proveedor() {
		return Id_Proveedor;
	}

	public void setId_Proveedor(int id_Proveedor) {
		Id_Proveedor = id_Proveedor;
	}
	
	
}
