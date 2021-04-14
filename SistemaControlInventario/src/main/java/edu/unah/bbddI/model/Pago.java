package edu.unah.bbddI.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "PAGO")
public class Pago {
	@Id
	private int Id_Pgo;
	private float importe_total;
	private float importe_x_cuota;
	private int cantidad_cuotas;
	private Date fecha_limite;
	
	@OneToMany(mappedBy="pago", fetch=FetchType.LAZY)
	private List<Cuota> cuota;
	
	@OneToMany(mappedBy="pago2", fetch=FetchType.LAZY)
	private List<Factura_Compra> factura_compra;
	
	@OneToMany(mappedBy="pago3", fetch=FetchType.LAZY)
	private List<Factura_Venta> factura_venta;
	
	@ManyToOne
	@JoinColumn(name="Id_Tipo_Pago")
	@JsonBackReference
	private Tipo_Pago tipo_pago;
	
	public Pago() {}

	public Pago(int id_Pgo, float importe_total, float importe_x_cuota, int cantidad_cuotas, Date fecha_limite,
			List<Cuota> cuota, Tipo_Pago tipo_pago) {
		super();
		Id_Pgo = id_Pgo;
		this.importe_total = importe_total;
		this.importe_x_cuota = importe_x_cuota;
		this.cantidad_cuotas = cantidad_cuotas;
		this.fecha_limite = fecha_limite;
		this.cuota = cuota;
		this.tipo_pago = tipo_pago;
	}

	public int getId_Pgo() {
		return Id_Pgo;
	}

	public void setId_Pgo(int id_Pgo) {
		Id_Pgo = id_Pgo;
	}

	public float getImporte_total() {
		return importe_total;
	}

	public void setImporte_total(float importe_total) {
		this.importe_total = importe_total;
	}

	public float getImporte_x_cuota() {
		return importe_x_cuota;
	}

	public void setImporte_x_cuota(float importe_x_cuota) {
		this.importe_x_cuota = importe_x_cuota;
	}

	public int getCantidad_cuotas() {
		return cantidad_cuotas;
	}

	public void setCantidad_cuotas(int cantidad_cuotas) {
		this.cantidad_cuotas = cantidad_cuotas;
	}

	public Date getFecha_limite() {
		return fecha_limite;
	}

	public void setFecha_limite(Date fecha_limite) {
		this.fecha_limite = fecha_limite;
	}

	public List<Cuota> getCuota() {
		return cuota;
	}

	public void setCuotas(List<Cuota> cuota) {
		this.cuota = cuota;
	}

	public Tipo_Pago getTipo_pago() {
		return tipo_pago;
	}

	public void setTipo_pago(Tipo_Pago tipo_pago) {
		this.tipo_pago = tipo_pago;
	}
	
	
	

}
