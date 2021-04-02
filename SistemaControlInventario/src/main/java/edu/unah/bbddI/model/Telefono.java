package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "TELEFONO")
public class Telefono {
	@Id
	private int id_Telefono;
	private String numero;
	
	public Telefono(int id_Telefono, String numero) {
		super();
		this.id_Telefono = id_Telefono;
		this.numero = numero;
	}

	public int getId_Telefono() {
		return id_Telefono;
	}

	public void setId_Telefono(int id_Telefono) {
		this.id_Telefono = id_Telefono;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}