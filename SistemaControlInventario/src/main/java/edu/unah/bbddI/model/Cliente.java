package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
public class Cliente {
	@Id
	private int Id_Cliente;
	private String p_nombre;
	private String s_nombre;
	private String p_apellido;
	private String s_apellido;
	private String correo;
	private String DNI;
	private String direccion;
	
	@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
	private List<Devolucion_Venta> devolucion_venta;
	
	@OneToMany(mappedBy="cliente2", fetch=FetchType.LAZY)
	private List<Factura_Venta> factura_venta;
	
	public Cliente() {}

	public Cliente(int id_Cliente, String p_nombre, String s_nombre, String p_apelido, String s_apellido, String correo,
			String dNI, String direccion) {
		super();
		Id_Cliente = id_Cliente;
		this.p_nombre = p_nombre;
		this.s_nombre = s_nombre;
		this.p_apellido = p_apelido;
		this.s_apellido = s_apellido;
		this.correo = correo;
		DNI = dNI;
		this.direccion = direccion;
	}

	public int getId_Cliente() {
		return Id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		Id_Cliente = id_Cliente;
	}

	public String getP_nombre() {
		return p_nombre;
	}

	public void setP_nombre(String p_nombre) {
		this.p_nombre = p_nombre;
	}

	public String getS_nombre() {
		return s_nombre;
	}

	public void setS_nombre(String s_nombre) {
		this.s_nombre = s_nombre;
	}

	public String getP_apellido() {
		return p_apellido;
	}

	public void setP_apellido(String p_apelido) {
		this.p_apellido = p_apelido;
	}

	public String getS_apellido() {
		return s_apellido;
	}

	public void setS_apellido(String s_apellido) {
		this.s_apellido = s_apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
