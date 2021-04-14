package edu.unah.bbddI.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "CUOTA")
public class Cuota {
	@Id
	private int Id_Cuota;
	private float total_abonado;
	private Date fecha_pago;
	
	@ManyToOne
	@JoinColumn(name="Id_Pago")
	@JsonBackReference
	private Pago pago;
	
	public Cuota() {}

	public Cuota(int id_Cuota, float total_abonado, Date fecha_pago, Pago pago) {
		super();
		Id_Cuota = id_Cuota;
		this.total_abonado = total_abonado;
		this.fecha_pago = fecha_pago;
		this.pago = pago;
	}

	public int getId_Cuota() {
		return Id_Cuota;
	}

	public void setId_Cuota(int id_Cuota) {
		Id_Cuota = id_Cuota;
	}

	public float getTotal_abandonado() {
		return total_abonado;
	}

	public void setTotal_abandonado(float total_abonado) {
		this.total_abonado = total_abonado;
	}

	public Date getFecha_pago() {
		return fecha_pago;
	}

	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

}
