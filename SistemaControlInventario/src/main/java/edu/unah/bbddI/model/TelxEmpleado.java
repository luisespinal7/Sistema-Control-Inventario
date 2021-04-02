package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TELXEMPLEADO")
public class TelxEmpleado {
	@Id
	private int Id_Telefono;
	@Id
	private int Id_Empleado;
	
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
