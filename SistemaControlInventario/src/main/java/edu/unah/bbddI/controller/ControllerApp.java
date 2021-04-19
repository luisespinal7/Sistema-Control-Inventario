package edu.unah.bbddI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.unah.bbddI.model.Cliente;
import edu.unah.bbddI.model.Marca;
import edu.unah.bbddI.model.Proveedor;
import edu.unah.bbddI.model.Telefono;
import edu.unah.bbddI.model.TelxCliente;
import edu.unah.bbddI.model.TelxProveedor;
import edu.unah.bbddI.model.Tipo_Producto;
import edu.unah.bbddI.service.ServiceCliente;
import edu.unah.bbddI.service.ServiceMarca;
import edu.unah.bbddI.service.ServiceProveedor;
import edu.unah.bbddI.service.ServiceTelefono;
import edu.unah.bbddI.service.ServiceTelxCliente;
import edu.unah.bbddI.service.ServiceTelxProveedor;
import edu.unah.bbddI.service.ServiceTipo_Producto;


@Controller
public class ControllerApp {
	
	@Autowired
	ServiceProveedor serviceProveedor;
	@Autowired
	ServiceTelefono serviceTelefono;
	@Autowired
	ServiceTelxProveedor serviceTelxProveedor;
	@Autowired
	ServiceCliente serviceCliente;
	@Autowired
	ServiceTelxCliente serviceTelxCliente;
	@Autowired
	ServiceTipo_Producto serviceTipo_Producto;
	@Autowired
	ServiceMarca serviceMarca;
	
	@GetMapping(value = {"/","/admin"})
	public String paginaPrincipal() {
		return "index";
	}
	
	
	//====================================================================
	//	Cliente
	//====================================================================
	
	@PostMapping(value = "/cliente/crearCliente")
	public String crearCliente(@RequestParam(name = "p_nombre") String primerNombre,
								@RequestParam(name = "s_nombre") String segundoNombre,
								@RequestParam(name = "p_apellido") String primerApellido,
								@RequestParam(name = "s_apellido") String segundoApellido,
								@RequestParam(name = "correo") String correo,
								@RequestParam(name = "dni") String dni,
								@RequestParam(name = "direccion") String direccion,
								@RequestParam(name = "telefono") String telefono) {
		Cliente cliente = new Cliente();
		cliente.setP_nombre(primerNombre);
		cliente.setS_nombre(segundoNombre);
		cliente.setP_apellido(primerApellido);
		cliente.setS_apellido(segundoApellido);
		cliente.setCorreo(correo);
		cliente.setDNI(dni);
		cliente.setDireccion(direccion);
		serviceCliente.crearCliente(cliente);
		
		Telefono telefonoProveedor = new Telefono();
		telefonoProveedor.setNumero(telefono);
		serviceTelefono.crear(telefonoProveedor);
		
		//agregar telefono al proveedor
		int tmpClienteId = this.serviceCliente.buscarxNombre(cliente.getP_nombre());
		int tmpTelefonoId = this.serviceTelefono.buscarxNumero(telefonoProveedor.getNumero());
		TelxCliente telxCliente = new TelxCliente(tmpTelefonoId, tmpClienteId);
		this.serviceTelxCliente.crear(telxCliente);
		
		return "redirect:/";
	}
	
	@PostMapping(value ="/cliente/actualizarCliente")
	public String actualizarCliente(@RequestParam(name = "id") int id,
                                @RequestParam(name = "p_nombre") String primerNombre,
								@RequestParam(name = "s_nombre") String segundoNombre,
								@RequestParam(name = "p_apellido") String primerApellido,
								@RequestParam(name = "s_apellido") String segundoApellido,
								@RequestParam(name = "correo") String correo,
								@RequestParam(name = "dni") String dni,
								@RequestParam(name = "direccion") String direccion) {
		Cliente cliente = this.serviceCliente.buscarCliente(id);
		if(!primerNombre.equals("")) {
			cliente.setP_nombre(primerNombre);
		}
		if(!segundoNombre.equals("")) {
			cliente.setS_nombre(segundoNombre);
		}
		if(!primerApellido.equals("")) {
			cliente.setP_apellido(primerApellido);
		}
		if(!segundoApellido.equals("")) {
			cliente.setS_apellido(segundoApellido);
		}
		if(!correo.equals("")) {
			cliente.setCorreo(correo);	
		}
		if(!dni.equals("")) {
			cliente.setDNI(dni);
		}
		if(!direccion.equals("")) {
			cliente.setDireccion(direccion);
		}
		serviceCliente.crearCliente(cliente);
		
		
		return "redirect:/";
	}
	
	//====================================================================
	//	Proveedor
	//====================================================================

	@PostMapping(value ="/proveedor/crearProveedor")
	public String crearProveedor(@RequestParam(name = "nombre") String nombre,
								@RequestParam(name = "correo") String correo,
								@RequestParam(name = "direccion") String direccion,
								@RequestParam(name = "telefono") String telefono,
								@RequestParam(name = "rtn") String rtn) {
		
		Proveedor proveedor = new Proveedor();
		proveedor.setNombre(nombre);
		proveedor.setCorreo(correo);
		proveedor.setDireccion(direccion);
		proveedor.setRTN(rtn);
		serviceProveedor.crear(proveedor);
		
		Telefono telefonoProveedor = new Telefono();
		telefonoProveedor.setNumero(telefono);
		serviceTelefono.crear(telefonoProveedor);
		
		
		//agregar telefono al proveedor
		int tmpProveedorId = this.serviceProveedor.buscarxNombre(proveedor.getNombre());
		int tmpTelefonoId = this.serviceTelefono.buscarxNumero(telefonoProveedor.getNumero());
		TelxProveedor telxProveedor = new TelxProveedor(tmpTelefonoId, tmpProveedorId);
		this.serviceTelxProveedor.crear(telxProveedor);
		
		return "redirect:/";
	} 
	
	
	@PostMapping(value ="/proveedor/actualizarProveedor")
	public String actualizarProveedor(
                                @RequestParam(name = "id") int id,
                                @RequestParam(name = "nombre") String nombre,
								@RequestParam(name = "correo") String correo,
								@RequestParam(name = "direccion") String direccion,
								@RequestParam(name = "rtn") String rtn) {
		
		Proveedor proveedor = this.serviceProveedor.buscar(id);
		if(!nombre.equals("")) {
			proveedor.setNombre(nombre);
		}
		if(!correo.equals("")) {
			proveedor.setCorreo(correo);
		}
		if(!direccion.equals("")) {
			proveedor.setDireccion(direccion);	
		}
		if(!rtn.equals("")) {
			proveedor.setRTN(rtn);
		}
		serviceProveedor.crear(proveedor);
		
		
		return "redirect:/";
	}
	
	//====================================================================
	//	Tipo producto
	//====================================================================
	@PostMapping(value = "/tipo/crearTipo")
	public String crearTipo(@RequestParam(name = "nombre") String nombre) {
		Tipo_Producto tipoProducto = new Tipo_Producto();
		tipoProducto.setNombre_tipo_producto(nombre);
		serviceTipo_Producto.crear(tipoProducto);
		return "redirect:/";
	}
	
	//====================================================================
	//	Marca
	//====================================================================
	@PostMapping(value = "/marca/crearMarca")
	public String crearMarca(@RequestParam(name = "nombre") String nombre) {
		Marca marca= new Marca();
		marca.setNombre_marca(nombre);
		serviceMarca.crear(marca);
		return "redirect:/";
	}
	
	//====================================================================
	//	Listados
	//====================================================================
	@RequestMapping(value ="proveedores/listaProveedores",method=RequestMethod.GET)
	public String listadoProveedores(Model model) {
		List<Proveedor> proveedores = this.serviceProveedor.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		
		return "proveedores";
	}

}
