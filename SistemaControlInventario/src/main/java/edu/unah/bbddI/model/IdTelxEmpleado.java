package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdTelxEmpleado implements Serializable{
	private int Id_Telefono;
	private int Id_Empleado;
	
	public IdTelxEmpleado(int id_Telefono, int id_Empleado) {
		super();
		Id_Telefono = id_Telefono;
		Id_Empleado = id_Empleado;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdTelxEmpleado) {
			IdTelxEmpleado tmpid = (IdTelxEmpleado)obj;
			if(this.Id_Telefono == tmpid.getId_Telefono()
				&& this.Id_Empleado == tmpid.getId_Empleado()) {
				return true;
			}else 
				return false;
		}else return false;	
	}
	
	public int hashCode() {
		return (int) this.Id_Telefono+this.Id_Empleado;
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