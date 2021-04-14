package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "TELEFONO")
public class Telefono {
	@Id
	private int Id_Telefono;
	private String numero;
	
	public Telefono() {}

	public Telefono(int id_Telefono, String numero) {
		super();
		this.Id_Telefono = id_Telefono;
		this.numero = numero;
	}

	public int getId_Telefono() {
		return Id_Telefono;
	}

	public void setId_Telefono(int id_Telefono) {
		this.Id_Telefono = id_Telefono;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
