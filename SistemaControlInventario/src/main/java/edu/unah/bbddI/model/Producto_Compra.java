package edu.unah.bbddI.model;

import java.io.Serializable;

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
@Table(name = "PRODUCTO_COMPRA")
public class Producto_Compra {
	
@IdClass(IdProducto_Compra.class)
public class Producto_Compra implements Serializable{
	@Id
	private int Id_Compra;
	@Id
	private int Id_Producto;
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
	@JoinColumn(name="Id_Compra", referencedColumnName="Id_Compra", insertable = false, updatable = false)
	@JsonBackReference
	private Factura_Compra factura_compra;
	
	@ManyToOne
	@JoinColumn(name="Id_Producto", referencedColumnName="Id_Producto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto2;
	
	public Producto_Compra(int id_Compra, int id_Producto, float precio_unitario, int cantidad) {
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
