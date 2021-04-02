package edu.unah.bbddI.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DEVOLUCION_COMPRA")
public class Devolucion_Compra {
	@Id
	private int Id_Dev_Compra;
	private Date fecha_devolucion;
	private float total;
	
	@ManyToOne
	@JoinColumn(name="Id_Proveedor")
	@JsonBackReference
	private Proveedor proveedor;

	public Devolucion_Compra(int id_Dev_Compra, Date fecha_devolucion, float total, Proveedor proveedor) {
		super();
		Id_Dev_Compra = id_Dev_Compra;
		this.fecha_devolucion = fecha_devolucion;
		this.total = total;
		this.proveedor = proveedor;
	}

	public int getId_Dev_Compra() {
		return Id_Dev_Compra;
	}

	public void setId_Dev_Compra(int id_Dev_Compra) {
		Id_Dev_Compra = id_Dev_Compra;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
}
