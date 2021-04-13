package edu.unah.bbddI.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "FACTURA_COMPRA")
public class Factura_Compra {
	@Id
	private int Id_Compra;
	private Date fecha;
	private float subtotal;
	private float descuento;
	private float total;
	
	@ManyToOne
	@JoinColumn(name="Id_Pago")
	@JsonBackReference
	private Pago pago2;
	
	
	@ManyToOne
	@JoinColumn(name="Id_Proveedor")
	@JsonBackReference
	private Proveedor proveedor2;


	public Factura_Compra(int id_Compra, Date fecha, float subtotal, float descuento, float total, Pago pago2,
			Proveedor proveedor2) {
		super();
		Id_Compra = id_Compra;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.descuento = descuento;
		this.total = total;
		this.pago2 = pago2;
		this.proveedor2 = proveedor2;
	}


	public int getId_Compra() {
		return Id_Compra;
	}


	public void setId_Compra(int id_Compra) {
		Id_Compra = id_Compra;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public float getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}


	public float getDescuento() {
		return descuento;
	}


	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total = total;
	}


	public Pago getPago2() {
		return pago2;
	}


	public void setPago2(Pago pago2) {
		this.pago2 = pago2;
	}


	public Proveedor getProveedor2() {
		return proveedor2;
	}


	public void setProveedor2(Proveedor proveedor2) {
		this.proveedor2 = proveedor2;
	}
	
	

}
