package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO_COMPRA")
public class Producto_Compra {
	
	private float precio_unitario;
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="Id_Compra")
	@JsonBackReference
	private Factura_Compra f_compra;
	
	@ManyToOne
	@JoinColumn(name="Id_Producto")
	@JsonBackReference
	private Producto producto;
	
	public Producto_Compra(float precio_unitario, int cantidad, Factura_Compra f_compra, Producto producto) {
		super();
		this.precio_unitario = precio_unitario;
		this.cantidad = cantidad;
		this.f_compra = f_compra;
		this.producto = producto;
	}

	public Factura_Compra getF_compra() {
		return f_compra;
	}

	public void setF_compra(Factura_Compra f_compra) {
		this.f_compra = f_compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public float getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(String precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
