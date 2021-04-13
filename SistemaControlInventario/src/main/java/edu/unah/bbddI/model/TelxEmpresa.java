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
@Table(name = "TELXEMPRESA")
@IdClass(IdTelxEmpresa.class)
public class TelxEmpresa implements Serializable{
	@Id
	private int Id_Telefono;
	@Id
	private int Id_Empresa;
	
	@OneToOne
	@JoinColumn(name="Id_Telefono", referencedColumnName="Id_Telefono", insertable = false, updatable = false)
	@JsonBackReference
	private Telefono telefono3;
	
	@ManyToOne
	@JoinColumn(name="Id_Empresa", referencedColumnName="Id_Empresa", insertable = false, updatable = false)
	@JsonBackReference
	private Empresa empresa3;
	
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
