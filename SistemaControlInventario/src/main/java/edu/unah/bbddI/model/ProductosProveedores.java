package edu.unah.bbddI.model;

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
@Table(name = "PRODUCTOSPROVEEDORES")
@IdClass(IdProductosProveedores.class)
public class ProductosProveedores {
	@Id
	private int Id_Producto;
	@Id
	private int Id_Proveedor;
	
	@ManyToOne
	@JoinColumn(name="Id_Producto", referencedColumnName="Id_Producto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto5;
	
	@ManyToOne
	@JoinColumn(name="Id_Proveedor", referencedColumnName="Id_Proveedor", insertable = false, updatable = false)
	@JsonBackReference
	private Proveedor proveedor4;

	public ProductosProveedores(int id_Producto, int id_Proveedor, Producto producto5, Proveedor proveedor4) {
		super();
		Id_Producto = id_Producto;
		Id_Proveedor = id_Proveedor;
		this.producto5 = producto5;
		this.proveedor4 = proveedor4;
	}

	public ProductosProveedores() {}

	public int getId_Producto() {
		return Id_Producto;
	}

	public void setId_Producto(int id_Producto) {
		Id_Producto = id_Producto;
	}

	public int getId_Proveedor() {
		return Id_Proveedor;
	}

	public void setId_Proveedor(int id_Proveedor) {
		Id_Proveedor = id_Proveedor;
	}

	public Producto getProducto5() {
		return producto5;
	}

	public void setProducto5(Producto producto5) {
		this.producto5 = producto5;
	}

	public Proveedor getProveedor4() {
		return proveedor4;
	}

	public void setProveedor4(Proveedor proveedor4) {
		this.proveedor4 = proveedor4;
	}
	
	
	
}
