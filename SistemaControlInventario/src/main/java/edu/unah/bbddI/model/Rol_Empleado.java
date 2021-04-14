package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROL_EMPLEADO")
public class Rol_Empleado {
	@Id
	private int Id_Rol ;
	private String rol_empleado;
	
	@OneToMany(mappedBy="rol_empleado", fetch=FetchType.LAZY)
	private List<Empleado> empleado;
	
	public Rol_Empleado() {}

	public Rol_Empleado(int id_Rol, String rol_empleado) {
		super();
		Id_Rol = id_Rol;
		this.rol_empleado = rol_empleado;
	}

	public int getId_Rol() {
		return Id_Rol;
	}

	public void setId_Rol(int id_Rol) {
		Id_Rol = id_Rol;
	}

	public String getRol_empleado() {
		return rol_empleado;
	}

	public void setRol_empleado(String rol_empleado) {
		this.rol_empleado = rol_empleado;
	}
	
	

}
