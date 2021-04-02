package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TELXCLIENTE")
public class TelxCliente {
	@Id
	private int Id_Telefono;
	@Id
	private int Id_Cliente;
	
	public TelxCliente(int id_Telefono, int id_Cliente) {
		super();
		Id_Telefono = id_Telefono;
		Id_Cliente = id_Cliente;
	}

	public int getId_Telefono() {
		return Id_Telefono;
	}

	public void setId_Telefono(int id_Telefono) {
		Id_Telefono = id_Telefono;
	}

	public int getId_Cliente() {
		return Id_Cliente;
	}

	public void setId_Cliente(int id_Cliente) {
		Id_Cliente = id_Cliente;
	}
	
	

}
