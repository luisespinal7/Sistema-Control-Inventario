package edu.unah.bbddI.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTOXDEV_COMPRA")
public class ProductoxDev_Compra {
	@Id
	private int Id_Dev_Compra;
	@Id
	private int Id_Producto;
	private int cantidad;
	private float precio_unitario;
	private String razon;
	
	public ProductoxDev_Compra(int id_Dev_Compra, int id_Producto, int cantidad, float precio_unitario, String razon) {
		super();
		Id_Dev_Compra = id_Dev_Compra;
		Id_Producto = id_Producto;
		this.cantidad = cantidad;
		this.precio_unitario = precio_unitario;
		this.razon = razon;
	}

	public int getId_Dev_Compra() {
		return Id_Dev_Compra;
	}

	public void setId_Dev_Compra(int id_Dev_Compra) {
		Id_Dev_Compra = id_Dev_Compra;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(float precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}
	
	

}
