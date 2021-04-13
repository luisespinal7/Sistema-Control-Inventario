package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Empresa {
	@Id
	private int Id_Empresa;
	private String nombre_empresa;
	private String direccion;
	private String RTN;
	private String correo;
	
	@OneToMany(mappedBy="empresa", fetch=FetchType.LAZY)
	private List<Empleado> empleado;
	
	@OneToMany(mappedBy="empresa2", fetch=FetchType.LAZY)
	private List<Factura_Venta> factura_venta;
	
	public Empresa(int id_Empresa, String nombre_empresa, String direccion, String rTN, String correo) {
		super();
		Id_Empresa = id_Empresa;
		this.nombre_empresa = nombre_empresa;
		this.direccion = direccion;
		RTN = rTN;
		this.correo = correo;
	}

	public int getId_Empresa() {
		return Id_Empresa;
	}

	public void setId_Empresa(int id_Empresa) {
		Id_Empresa = id_Empresa;
	}

	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	

}
