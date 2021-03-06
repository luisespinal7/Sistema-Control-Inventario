package edu.unah.bbddI.model;

import java.time.LocalDate;
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
	private LocalDate fecha_caducidad;
	private float precio_venta;
	private String medida;
	private int cantidad_disponible;
	private String codigo_barra;
	
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
	
	public Producto() {}

	public Producto(int id_Producto, String nombre_producto, LocalDate fecha_caducidad, float precio_venta, String medida,
			int cantidad_disponible, String codigo_barra, Tipo_Producto tipo_producto, Seccion_Producto seccion_producto,
			Marca marca) {
		super();
		Id_Producto = id_Producto;
		this.nombre_producto = nombre_producto;
		this.fecha_caducidad = fecha_caducidad;
		this.precio_venta = precio_venta;
		this.medida = medida;
		this.cantidad_disponible = cantidad_disponible;
		this.codigo_barra = codigo_barra;
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

	public LocalDate getFecha_caducidad() {
		return fecha_caducidad;
	}

	public void setFecha_caducidad(LocalDate fecha_caducidad) {
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
	
	public String getCodigo_barra() {
		return codigo_barra;
	}

	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
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
