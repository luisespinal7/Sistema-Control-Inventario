package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TELXPROVEEDOR")
public class TelxProveedor {
	@Id
	private int Id_Telefono;
	@Id
	private int Id_Proveedor;
	
	public TelxProveedor(int id_Telefono, int id_Proveedor) {
		super();
		Id_Telefono = id_Telefono;
		Id_Proveedor = id_Proveedor;
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
