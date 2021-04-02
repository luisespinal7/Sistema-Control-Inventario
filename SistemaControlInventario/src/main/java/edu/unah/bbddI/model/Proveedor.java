package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROVEEDOR")
public class Proveedor {
	@Id
	private int Id_Proveedor;
	private String nombre;
	private String correo;
	private String direccion;
	private String RTN;
	
	@OneToMany(mappedBy="proveedor", fetch=FetchType.LAZY)
	private List<Devolucion_Compra> devolucion_compra;
	
	@OneToMany(mappedBy="proveedor2", fetch=FetchType.LAZY)
	private List<Factura_Compra> factura_compra;
	
	public Proveedor(int id_Proveedor, String nombre, String correo, String direccion, String rTN) {
		super();
		Id_Proveedor = id_Proveedor;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		RTN = rTN;
	}

	public int getId_Proveedor() {
		return Id_Proveedor;
	}

	public void setId_Proveedor(int id_Proveedor) {
		Id_Proveedor = id_Proveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getRTN() {
		return RTN;
	}

	public void setRTN(String rTN) {
		RTN = rTN;
	}
	
	

}
