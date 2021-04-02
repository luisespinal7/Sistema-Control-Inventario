package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TELXEMPRESA")
public class TelxEmpresa {
	@Id
	private int Id_Telefono;
	@Id
	private int Id_Empresa;
	
	public TelxEmpresa(int id_Telefono, int id_Empresa) {
		super();
		Id_Telefono = id_Telefono;
		Id_Empresa = id_Empresa;
	}

	public int getId_Telefono() {
		return Id_Telefono;
	}

	public void setId_Telefono(int id_Telefono) {
		Id_Telefono = id_Telefono;
	}

	public int getId_Empresa() {
		return Id_Empresa;
	}

	public void setId_Empresa(int id_Empresa) {
		Id_Empresa = id_Empresa;
	}
	
	

}
