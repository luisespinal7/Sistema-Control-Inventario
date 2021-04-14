package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "TELXPROVEEDOR")
@IdClass(IdTelxProveedor.class)
public class TelxProveedor implements Serializable{
	@Id
	private int Id_Telefono;
	@Id
	private int Id_Proveedor;
	
	@OneToOne
	@JoinColumn(name="Id_Telefono", referencedColumnName="Id_Telefono", insertable = false, updatable = false)
	@JsonBackReference
	private Telefono telefono4;
	
	@ManyToOne
	@JoinColumn(name="Id_Proveedor", referencedColumnName="Id_Proveedor", insertable = false, updatable = false)
	@JsonBackReference
	private Proveedor proveedor3;
	
	public TelxProveedor() {}

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
