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
@Table(name = "TELXCLIENTE")
@IdClass(IdTelxCliente.class)
public class TelxCliente implements Serializable{
	@Id
	private int Id_Telefono;
	@Id
	private int Id_Cliente;
	
	@OneToOne
	@JoinColumn(name="Id_Telefono", referencedColumnName="Id_Telefono", insertable = false, updatable = false)
	@JsonBackReference
	private Telefono telefono;
	
	@ManyToOne
	@JoinColumn(name="Id_Cliente", referencedColumnName="Id_Cliente", insertable = false, updatable = false)
	@JsonBackReference
	private Cliente cliente3;
	
	public TelxCliente() {}

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
