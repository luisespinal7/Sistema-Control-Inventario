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
@IdClass(IdProducto_Compra.class)
public class Producto_Compra implements Serializable{
	@Id
	private int Id_Compra;
	@Id
	private int Id_Producto;
	private float precio_unitario;
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name="Id_Compra", referencedColumnName="Id_Compra", insertable = false, updatable = false)
	@JsonBackReference
	private Factura_Compra factura_compra;
	
	@ManyToOne
	@JoinColumn(name="Id_Producto", referencedColumnName="Id_Producto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto2;
	
	public Producto_Compra(int id_Compra, int id_Producto, float precio_unitario, int cantidad) {
		super();
		Id_Compra = id_Compra;
		Id_Producto = id_Producto;
		this.precio_unitario = precio_unitario;
		this.cantidad = cantidad;
	}

	public int getId_Compra() {
		return Id_Compra;
	}

	public void setId_Compra(int id_Compra) {
		Id_Compra = id_Compra;
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
