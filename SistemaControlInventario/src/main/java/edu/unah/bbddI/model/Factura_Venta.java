package edu.unah.bbddI.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "FACTURA_VENTA")
public class Factura_Venta {
	@Id
	private int Id_Venta;
	private Date fecha;
	private float subtotal;
	private float total;
	private boolean cancelo;
	
	@ManyToOne
	@JoinColumn(name="Id_Cliente")
	@JsonBackReference
	private Cliente cliente2;
	
	@ManyToOne
	@JoinColumn(name="Id_Descuento")
	@JsonBackReference
	private Descuento descuento;
	
	@ManyToOne
	@JoinColumn(name="Id_Empleado")
	@JsonBackReference
	private Empleado empleado2;
	
	@ManyToOne
	@JoinColumn(name="Id_Empresa")
	@JsonBackReference
	private Empresa empresa2;
	
	@ManyToOne
	@JoinColumn(name="Id_Pago")
	@JsonBackReference
	private Pago pago3;

	public Factura_Venta(int id_Venta, Date fecha, float subtotal, float total, boolean cancelo, Cliente cliente2,
			Descuento descuento, Empleado empleado2, Empresa empresa2, Pago pago3) {
		super();
		Id_Venta = id_Venta;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.total = total;
		this.cancelo = cancelo;
		this.cliente2 = cliente2;
		this.descuento = descuento;
		this.empleado2 = empleado2;
		this.empresa2 = empresa2;
		this.pago3 = pago3;
	}

	public int getId_Venta() {
		return Id_Venta;
	}

	public void setId_Venta(int id_Venta) {
		Id_Venta = id_Venta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public boolean isCancelo() {
		return cancelo;
	}

	public void setCancelo(boolean cancelo) {
		this.cancelo = cancelo;
	}

	public Cliente getCliente2() {
		return cliente2;
	}

	public void setCliente2(Cliente cliente2) {
		this.cliente2 = cliente2;
	}

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public Empleado getEmpleado2() {
		return empleado2;
	}

	public void setEmpleado2(Empleado empleado2) {
		this.empleado2 = empleado2;
	}

	public Empresa getEmpresa2() {
		return empresa2;
	}

	public void setEmpresa2(Empresa empresa2) {
		this.empresa2 = empresa2;
	}

	public Pago getPago3() {
		return pago3;
	}

	public void setPago3(Pago pago3) {
		this.pago3 = pago3;
	}
	
	
}
