package edu.unah.bbddI.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Embeddable
public class IdTelxEmpresa implements Serializable{
	private int Id_Telefono;
	private int Id_Empresa;
	
	public IdTelxEmpresa() {}

	public IdTelxEmpresa(int id_Telefono, int id_Empresa) {
		super();
		Id_Telefono = id_Telefono;
		Id_Empresa = id_Empresa;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof IdTelxEmpresa) {
			IdTelxEmpresa tmpid = (IdTelxEmpresa)obj;
			if(this.Id_Telefono == tmpid.getId_Telefono()
				&& this.Id_Empresa == tmpid.getId_Empresa()) {
				return true;
			}else 
				return false;
		}else return false;	
	}
	
	public int hashCode() {
		return (int) this.Id_Telefono+this.Id_Empresa;
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