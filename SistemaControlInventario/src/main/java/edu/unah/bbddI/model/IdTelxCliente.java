package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdTelxCliente implements Serializable{
	private int Id_Telefono;
	private int Id_Cliente;
	
	public IdTelxCliente(int id_Telefono, int id_Cliente) {
		super();
		Id_Telefono = id_Telefono;
		Id_Cliente = id_Cliente;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdTelxCliente) {
			IdTelxCliente tmpid = (IdTelxCliente)obj;
			if(this.Id_Telefono == tmpid.getId_Telefono()
				&& this.Id_Cliente == tmpid.getId_Cliente()) {
				return true;
			}else 
				return false;
		}else return false;	
	}
	
	public int hashCode() {
		return (int) this.Id_Telefono+this.Id_Cliente;
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