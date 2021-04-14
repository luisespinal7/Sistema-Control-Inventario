package edu.unah.bbddI.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DESCUENTO")
public class Descuento {
	@Id
	private int Id_Descuento;
	private String tipo_descuento;
	private float descuento;
	
	@OneToMany(mappedBy="descuento", fetch=FetchType.EAGER)
	private List<Factura_Venta> factura_venta;
	
	public Descuento() {}

	public Descuento(int id_Descuento, String tipo_descuento, float descuento) {
		super();
		Id_Descuento = id_Descuento;
		this.tipo_descuento = tipo_descuento;
		this.descuento = descuento;
	}

	public int getId_Descuento() {
		return Id_Descuento;
	}

	public void setId_Descuento(int id_Descuento) {
		Id_Descuento = id_Descuento;
	}

	public String getTipo_descuento() {
		return tipo_descuento;
	}

	public void setTipo_descuento(String tipo_descuento) {
		this.tipo_descuento = tipo_descuento;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
	

}
