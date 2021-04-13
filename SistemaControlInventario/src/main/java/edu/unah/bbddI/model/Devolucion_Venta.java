package edu.unah.bbddI.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "DEVOLUCION_VENTA")
public class Devolucion_Venta {
	@Id
	private int Id_Dev_Venta;
	private Date fecha_devolucion;
	private float  total;
	
	@ManyToOne
	@JoinColumn(name="Id_Cliente")
	@JsonBackReference
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="Id_Empleado")
	@JsonBackReference
	private Empleado empleado;

	public Devolucion_Venta(int id_Dev_Venta, Date fecha_devolucion, float total, Cliente cliente, Empleado empleado) {
		super();
		Id_Dev_Venta = id_Dev_Venta;
		this.fecha_devolucion = fecha_devolucion;
		this.total = total;
		this.cliente = cliente;
		this.empleado = empleado;
	}

	public int getId_Dev_Venta() {
		return Id_Dev_Venta;
	}

	public void setId_Dev_Venta(int id_Dev_Venta) {
		Id_Dev_Venta = id_Dev_Venta;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
}
