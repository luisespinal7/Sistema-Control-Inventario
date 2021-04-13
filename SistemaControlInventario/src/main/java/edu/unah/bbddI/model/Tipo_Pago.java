package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_PAGO")
public class Tipo_Pago {
	@Id
	private int Id_Tipo_Pago;
	private String nombre_tipo_Pago;
	
	@OneToMany(mappedBy="tipo_pago", fetch=FetchType.LAZY)
	private List<Pago> pago;
	
	public Tipo_Pago(int id_Tipo_Pago, String nombre_tipo_Pago) {
		super();
		Id_Tipo_Pago = id_Tipo_Pago;
		this.nombre_tipo_Pago = nombre_tipo_Pago;
	}

	public int getId_Tipo_Pago() {
		return Id_Tipo_Pago;
	}

	public void setId_Tipo_Pago(int id_Tipo_Pago) {
		Id_Tipo_Pago = id_Tipo_Pago;
	}

	public String getNombre_tipo_Pago() {
		return nombre_tipo_Pago;
	}

	public void setNombre_tipo_Pago(String nombre_tipo_Pago) {
		this.nombre_tipo_Pago = nombre_tipo_Pago;
	}
	
	

}
