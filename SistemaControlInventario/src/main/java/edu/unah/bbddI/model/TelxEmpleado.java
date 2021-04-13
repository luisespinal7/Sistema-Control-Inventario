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
@Table(name = "TELXEMPLEADO")
@IdClass(IdTelxEmpleado.class)
public class TelxEmpleado implements Serializable{
	@Id
	private int Id_Telefono;
	@Id
	private int Id_Empleado;
	
	@OneToOne
	@JoinColumn(name="Id_Telefono", referencedColumnName="Id_Telefono", insertable = false, updatable = false)
	@JsonBackReference
	private Telefono telefono2;
	
	@ManyToOne
	@JoinColumn(name="Id_Empleado", referencedColumnName="Id_Empleado", insertable = false, updatable = false)
	@JsonBackReference
	private Empleado empleado3;
	
	public TelxEmpleado(int id_Telefono, int id_Empleado) {
		super();
		Id_Telefono = id_Telefono;
		Id_Empleado = id_Empleado;
	}

	public int getId_Telefono() {
		return Id_Telefono;
	}

	public void setId_Telefono(int id_Telefono) {
		Id_Telefono = id_Telefono;
	}

	public int getId_Empleado() {
		return Id_Empleado;
	}

	public void setId_Empleado(int id_Empleado) {
		Id_Empleado = id_Empleado;
	}
	
	

}
