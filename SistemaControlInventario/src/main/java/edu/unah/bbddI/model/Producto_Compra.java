package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO_COMPRA")
public class Producto_Compra {
	@Id
	private int Id_Compra;
	@Id
	private int Id_Producto;
	private float precio_unitario;
	private int cantidad;
	
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
