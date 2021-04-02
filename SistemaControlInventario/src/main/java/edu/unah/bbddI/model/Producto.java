package edu.unah.bbddI.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PRODUCTO")
public class Producto {

	@Id
	private int Id_Producto;
	private String nombre_producto;
	private Date fecha_caducidad;
	private float precio_venta;
	private String medida;
	private int cantidad_disponible;
	private int cantidad_media;
	
	@ManyToOne
	@JoinColumn(name="Id_Tipo_Producto")
	@JsonBackReference
	private Tipo_Producto tipo_producto;
	
	@ManyToOne
	@JoinColumn(name="Id_Seccion_Producto")
	@JsonBackReference
	private Seccion_Producto seccion_producto;
	
	@ManyToOne
	@JoinColumn(name="Id_Marca")
	@JsonBackReference
	private Marca marca;

	public Producto(int id_Producto, String nombre_producto, Date fecha_caducidad, float precio_venta, String medida,
			int cantidad_disponible, int cantidad_media, Tipo_Producto tipo_producto, Seccion_Producto seccion_producto,
			Marca marca) {
		super();
		Id_Producto = id_Producto;
		this.nombre_producto = nombre_producto;
		this.fecha_caducidad = fecha_caducidad;
		this.precio_venta = precio_venta;
		this.medida = medida;
		this.cantidad_disponible = cantidad_disponible;
		this.cantidad_media = cantidad_media;
		this.tipo_producto = tipo_producto;
		this.seccion_producto = seccion_producto;
		this.marca = marca;
	}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Date getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(Date fecha_caducidad) {
		this.fecha_caducidad = fecha_caducidad;
	}

	public float getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(float precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public int getCantidad_disponible() {
		return cantidad_disponible;
	}

	public void setCantidad_disponible(int cantidad_disponible) {
		this.cantidad_disponible = cantidad_disponible;
	}

	public int getCantidad_media() {
		return cantidad_media;
	}

	public void setCantidad_media(int cantidad_media) {
		this.cantidad_media = cantidad_media;
	}

	public Tipo_Producto getTipo_producto() {
		return tipo_producto;
	}

	public void setTipo_producto(Tipo_Producto tipo_producto) {
		this.tipo_producto = tipo_producto;
	}

	public Seccion_Producto getSeccion_producto() {
		return seccion_producto;
	}

	public void setSeccion_producto(Seccion_Producto seccion_producto) {
		this.seccion_producto = seccion_producto;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
}