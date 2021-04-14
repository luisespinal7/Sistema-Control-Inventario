package edu.unah.bbddI.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "EMPLEADO")
public class Empleado {
	@Id
	private int Id_Empleado;
	private String p_nombre;
	private String s_nombre;
	private String p_apellido;
	private String s_apellido;
	private String correo;
	private int edad;
	private Date fecha_ingreso;
	private float salario;
	private String DNI;
	private String usuario;
	private String contrasenia;
	
	@ManyToOne
	@JoinColumn(name="Id_Empresa")
	@JsonBackReference
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="Id_Sexo")
	@JsonBackReference
	private Sexo sexo;
	
	@ManyToOne
	@JoinColumn(name="Id_Rol")
	@JsonBackReference
	private Rol_Empleado rol_empleado;
	
	@OneToMany(mappedBy="empleado2", fetch=FetchType.LAZY)
	private List<Factura_Venta> factura_venta;
	
	public Empleado() {}

	public Empleado(int id_Empleado, String p_nombre, String s_nombre, String p_apellido, String s_apellido,
			String correo, int edad, Date fecha_ingreso, float salario, String dNI, String usuario, String contrasenia,
			Empresa empresa, Sexo sexo, Rol_Empleado rol_empleado) {
		super();
		Id_Empleado = id_Empleado;
		this.p_nombre = p_nombre;
		this.s_nombre = s_nombre;
		this.p_apellido = p_apellido;
		this.s_apellido = s_apellido;
		this.correo = correo;
		this.edad = edad;
		this.fecha_ingreso = fecha_ingreso;
		this.salario = salario;
		DNI = dNI;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.empresa = empresa;
		this.sexo = sexo;
		this.rol_empleado = rol_empleado;
	}

	public int getId_Empleado() {
		return Id_Empleado;
	}

	public void setId_Empleado(int id_Empleado) {
		Id_Empleado = id_Empleado;
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

	public void setP_apellido(String p_apellido) {
		this.p_apellido = p_apellido;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Rol_Empleado getRol_empleado() {
		return rol_empleado;
	}

	public void setRol_empleado(Rol_Empleado rol_empleado) {
		this.rol_empleado = rol_empleado;
	}
	
	
}
