package edu.unah.bbddI.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.unah.bbddI.model.Cliente;
import edu.unah.bbddI.model.Cuota;
import edu.unah.bbddI.model.Descuento;
import edu.unah.bbddI.model.Devolucion_Compra;
import edu.unah.bbddI.model.Devolucion_Venta;
import edu.unah.bbddI.model.Empleado;
import edu.unah.bbddI.model.Empresa;
import edu.unah.bbddI.model.Factura_Compra;
import edu.unah.bbddI.model.Factura_Venta;
import edu.unah.bbddI.model.Marca;
import edu.unah.bbddI.model.Pago;
import edu.unah.bbddI.model.Producto;
import edu.unah.bbddI.model.Proveedor;
import edu.unah.bbddI.model.Rol_Empleado;
import edu.unah.bbddI.model.Seccion_Producto;
import edu.unah.bbddI.model.Sexo;
import edu.unah.bbddI.model.Tipo_Pago;
import edu.unah.bbddI.model.Tipo_Producto;
import edu.unah.bbddI.service.ServiceCliente;
import edu.unah.bbddI.service.ServiceCuota;
import edu.unah.bbddI.service.ServiceDescuento;
import edu.unah.bbddI.service.ServiceDevolucion_Compra;
import edu.unah.bbddI.service.ServiceDevolucion_Venta;
import edu.unah.bbddI.service.ServiceEmpleado;
import edu.unah.bbddI.service.ServiceEmpresa;
import edu.unah.bbddI.service.ServiceFactura_Compra;
import edu.unah.bbddI.service.ServiceFactura_Venta;
import edu.unah.bbddI.service.ServiceMarca;
import edu.unah.bbddI.service.ServicePago;
import edu.unah.bbddI.service.ServiceProducto;
import edu.unah.bbddI.service.ServiceProveedor;
import edu.unah.bbddI.service.ServiceRol_Empleado;
import edu.unah.bbddI.service.ServiceSeccion_Producto;
import edu.unah.bbddI.service.ServiceSexo;
import edu.unah.bbddI.service.ServiceTipo_Pago;
import edu.unah.bbddI.service.ServiceTipo_Producto;

@Controller
public class ControllerCreate {
	
	@Autowired
	ServiceProveedor serviceProveedor;
	@Autowired
	ServiceCliente serviceCliente;
	@Autowired
	ServiceSexo serviceSexo;
	@Autowired
	ServiceEmpresa serviceEmpresa;
	@Autowired
	ServiceRol_Empleado serviceRol;
	@Autowired
	ServiceEmpleado serviceEmpleado;
	@Autowired
	ServicePago servicePago;
	@Autowired
	ServiceCuota serviceCuota;
	@Autowired
	ServiceTipo_Pago serviceTipo_Pago;
	@Autowired
	ServiceDescuento serviceDescuento;
	@Autowired
	ServiceMarca serviceMarca;
	@Autowired
	ServiceTipo_Producto serviceTipoProducto;
	@Autowired
	ServiceSeccion_Producto serviceSeccion;
	@Autowired
	ServiceProducto serviceProducto;
	@Autowired
	ServiceFactura_Venta serviceVenta;
	@Autowired
	ServiceFactura_Compra serviceCompra;
	@Autowired
	ServiceDevolucion_Compra serviceDevCompra;
	@Autowired
	ServiceDevolucion_Venta serviceDevVenta;
	
	@PostMapping(value ="/create/proveedor")
	public String crearProveedor(@RequestParam(name = "id") int idProveedor,
								@RequestParam(name = "nombre") String nombre,
								@RequestParam(name = "correo") String correo,
								@RequestParam(name = "direccion") String direccion,
								@RequestParam(name = "rtn") String rtn) {
		
		Proveedor proveedor = new Proveedor();
		proveedor.setId_Proveedor(idProveedor);
		proveedor.setNombre(nombre);
		proveedor.setCorreo(correo);
		proveedor.setDireccion(direccion);
		proveedor.setRTN(rtn);
		serviceProveedor.crear(proveedor);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/cliente")
	public String crearCliente(@RequestParam(name = "id") int idCliente,
								@RequestParam(name = "pN") String pN,
								@RequestParam(name = "sN") String sN,
								@RequestParam(name = "pA") String pA,
								@RequestParam(name = "sA") String sA,
								@RequestParam(name = "correo") String correo,
								@RequestParam(name = "direccion") String direccion,
								@RequestParam(name = "dni") String dni) {
		
		Cliente cliente = new Cliente(idCliente, pN, sN, pA, sA, correo, dni, direccion);
		serviceCliente.crearCliente(cliente);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/empleado")
	public String crearEmpleado(@RequestParam(name = "id") int idEmpleado,
								@RequestParam(name = "pN") String pN,
								@RequestParam(name = "sN") String sN,
								@RequestParam(name = "pA") String pA,
								@RequestParam(name = "sA") String sA,
								@RequestParam(name = "correo") String correo,
								@RequestParam(name = "direccion") Date fechaIngreso,
								@RequestParam(name = "dni") String dni,
								@RequestParam(name = "edad") int edad,
								@RequestParam(name = "salario") float salario,
								@RequestParam(name = "sexo") int sexo,
								@RequestParam(name = "rol") int rol) {
		
		Sexo sex = serviceSexo.buscar(sexo);
		Rol_Empleado rolE = serviceRol.buscar(rol);
		Empresa empresa = serviceEmpresa.buscar(2021);
		Empleado empleado = new Empleado(idEmpleado, pN, sN, pA, sA, correo, edad, fechaIngreso, salario, dni, empresa, sex, rolE);
		serviceEmpleado.crear(empleado);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/cuota")
	public String crearCuota(@RequestParam(name = "id") int idCuota,
								@RequestParam(name = "abonado") float abonado,
								@RequestParam(name = "fecha") Date fecha,
								@RequestParam(name = "pago") int pagoID) {
		Pago pago = servicePago.buscar(pagoID);
		Cuota cuota = new Cuota(idCuota, abonado, fecha, pago);
		serviceCuota.crear(cuota);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/pago")
	public String crearPago(@RequestParam(name = "id") int idPago,
								@RequestParam(name = "iTotal") float iTotal,
								@RequestParam(name = "iCuota") float iCuota,
								@RequestParam(name = "fechaLimite") Date fechaLimite,
								@RequestParam(name = "cuotas") int cuotas,
								@RequestParam(name = "tipo") int tipo) {
		
		Tipo_Pago tipoPago = serviceTipo_Pago.buscar(tipo);
		//Pago pago = new Pago (idPago, iTotal, iCuota, cuotas, fechaLimite, tipoPago);
		//servicePago.crear(pago);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/descuento")
	public String crearDescuento(@RequestParam(name = "id") int idDescuento,
								@RequestParam(name = "tipo") String tipo,
								@RequestParam(name = "descuento") float desc) {
		
		Descuento descuento = new Descuento(idDescuento, tipo, desc);
		serviceDescuento.crear(descuento);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/marca")
	public String crearMarca(@RequestParam(name = "id") int idMarca,
								@RequestParam(name = "tipo") String nombre) {
		
		Marca marca = new Marca(idMarca, nombre);
		serviceMarca.crear(marca);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/tipoProducto")
	public String crearTipo_Producto(@RequestParam(name = "id") int idTipo,
								@RequestParam(name = "tipo") String nombre) {
		
		Tipo_Producto tipo = new Tipo_Producto(idTipo, nombre);
		serviceTipoProducto.crear(tipo);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/seccion")
	public String crearSeccion(@RequestParam(name = "id") int idSeccion,
								@RequestParam(name = "seccion") String nombre) {
		
		Seccion_Producto seccion = new Seccion_Producto(idSeccion, nombre);
		serviceSeccion.crear(seccion);
		return "redirect:/";
	} 

	@PostMapping(value ="/create/producto")
	public String crearProducto(@RequestParam(name = "id") int idProducto,
								@RequestParam(name = "nombre") String nombre,
								@RequestParam(name = "vence") Date vence,
								@RequestParam(name = "precio") float precio,
								@RequestParam(name = "medida") String medida,
								@RequestParam(name = "disponibles") int disponibles,
								@RequestParam(name = "media") int media,
								@RequestParam(name = "seccion") int idseccion,
								@RequestParam(name = "tipo") int idtipo,
								@RequestParam(name = "marca") int idmarca) {
		
		Seccion_Producto seccion = serviceSeccion.buscar(idseccion);
		Tipo_Producto tipo = serviceTipoProducto.buscar(idtipo);
		Marca marca = serviceMarca.buscar(idmarca);
		//Producto producto = new Producto(idProducto, nombre, vence, precio, medida, disponibles, media, tipo, seccion, marca);
		//serviceProducto.crear(producto);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/factura/venta")
	public String crearVenta(@RequestParam(name = "id") int idVenta,
								@RequestParam(name = "fecha") Date fecha,
								@RequestParam(name = "subtotal") float subtotal,
								@RequestParam(name = "total") float total,
								@RequestParam(name = "cancelo") boolean cancelo,
								@RequestParam(name = "cliente") int idcliente,
								@RequestParam(name = "empleado") int idempleado,
								@RequestParam(name = "pago") int idpago,
								@RequestParam(name = "descuento") int idescuento,
								@RequestParam(name = "empresa") int idempresa) {
		
		Cliente cliente = serviceCliente.buscarCliente(idcliente);
		Empleado empleado = serviceEmpleado.buscar(idempleado);
		Pago pago = servicePago.buscar(idpago);
		Descuento descuento = serviceDescuento.buscar(idescuento);
		Empresa empresa = serviceEmpresa.buscar(idempresa);
		Factura_Venta venta = new Factura_Venta(idVenta, fecha, subtotal, total, cancelo, cliente, descuento, empleado, empresa, pago);
		serviceVenta.crear(venta);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/factura/compra")
	public String crearCompra(@RequestParam(name = "id") int idCompra,
								@RequestParam(name = "fecha") Date fecha,
								@RequestParam(name = "subtotal") float subtotal,
								@RequestParam(name = "total") float total,
								@RequestParam(name = "descuento") float descuento,
								@RequestParam(name = "proveedor") int idproveedor,
								@RequestParam(name = "pago") int idpago) {
		
		Proveedor proveedor = serviceProveedor.buscar(idproveedor);
		Pago pago = servicePago.buscar(idpago);
		Factura_Compra compra = new Factura_Compra(idCompra, fecha, subtotal, descuento, total, pago, proveedor);
		serviceCompra.crear(compra);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/devolucion/venta")
	public String crearDevVenta(@RequestParam(name = "id") int idDevVenta,
								@RequestParam(name = "fecha") Date fecha,
								@RequestParam(name = "total") float total,
								@RequestParam(name = "cliente") int idcliente,
								@RequestParam(name = "empleado") int idempleado) {
		
		Cliente cliente = serviceCliente.buscarCliente(idcliente);
		Empleado empleado = serviceEmpleado.buscar(idempleado);
		Devolucion_Venta devVenta = new Devolucion_Venta(idDevVenta, fecha, total, cliente, empleado);
		serviceDevVenta.crear(devVenta);
		return "redirect:/";
	} 
	
	@PostMapping(value ="/create/devolucion/compra")
	public String crearDevCompra(@RequestParam(name = "id") int idDevCompra,
								@RequestParam(name = "fecha") Date fecha,
								@RequestParam(name = "total") float total,
								@RequestParam(name = "proveedor") int idproveedor) {
		
		Proveedor proveedor = serviceProveedor.buscar(idproveedor);
		Devolucion_Compra devCompra = new Devolucion_Compra(idDevCompra, fecha, total, proveedor);
		serviceDevCompra.crear(devCompra);
		return "redirect:/";
	}
	
}
