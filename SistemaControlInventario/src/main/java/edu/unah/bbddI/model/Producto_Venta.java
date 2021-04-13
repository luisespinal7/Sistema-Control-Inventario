package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "PRODUCTO_VENTA")
@IdClass(IdProducto_Venta.class)
public class Producto_Venta {
	@Id
	private int Id_Venta;
	@Id
	private int Id_Producto;
	private float precio_unitario;
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="Id_Venta", referencedColumnName="Id_Venta", insertable = false, updatable = false)
	@JsonBackReference
	private Factura_Venta factura_venta;
	
	@ManyToOne
	@JoinColumn(name="Id_Producto", referencedColumnName="Id_Producto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto3;
	
	public Producto_Venta(int id_Venta, int id_Producto, float precio_unitario, int cantidad) {
		super();
		Id_Venta = id_Venta;
		Id_Producto = id_Producto;
		this.precio_unitario = precio_unitario;
		this.cantidad = cantidad;
	}

	public int getId_Venta() {
		return Id_Venta;
	}

	public void setId_Venta(int id_Venta) {
		Id_Venta = id_Venta;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}

	public float getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
