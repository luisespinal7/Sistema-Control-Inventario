package edu.unah.bbddI.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.unah.bbddI.model.Cliente;
import edu.unah.bbddI.model.Marca;
import edu.unah.bbddI.model.Producto;
import edu.unah.bbddI.model.ProductosProveedores;
import edu.unah.bbddI.model.Proveedor;
import edu.unah.bbddI.model.Seccion_Producto;
import edu.unah.bbddI.model.Telefono;
import edu.unah.bbddI.model.TelxCliente;
import edu.unah.bbddI.model.TelxProveedor;
import edu.unah.bbddI.model.Tipo_Producto;
import edu.unah.bbddI.service.ServiceCliente;
import edu.unah.bbddI.service.ServiceMarca;
import edu.unah.bbddI.service.ServiceProducto;
import edu.unah.bbddI.service.ServiceProductosProveedores;
import edu.unah.bbddI.service.ServiceProveedor;
import edu.unah.bbddI.service.ServiceSeccion_Producto;
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
	@Autowired
	ServiceSeccion_Producto serviceSeccion_Producto;
	@Autowired
	ServiceProducto serviceProducto;
	@Autowired
	ServiceProductosProveedores serviceProductosProveedores;
	
	@GetMapping(value = {"/","/admin"})
	public String paginaPrincipal(Model model) {
		try {
			//Todos los modelos que ocuparan las paginas por defecto para popular la informaci??n
			List<Tipo_Producto> tiposDeProductos = this.serviceTipo_Producto.obtenerTodos();
			List<Seccion_Producto> seccionesDeProductos = this.serviceSeccion_Producto.obtenerTodos();
			List<Marca> marcasDeProductos = this.serviceMarca.obtenerTodos();
			List<Producto> productos = this.serviceProducto.obtenerTodos();
			List<Proveedor> proveedores = this.serviceProveedor.obtenerTodos();
			model.addAttribute("tiposDeProductos", tiposDeProductos);
			model.addAttribute("seccionesDeProductos", seccionesDeProductos);
			model.addAttribute("marcasDeProductos", marcasDeProductos);
			model.addAttribute("productos", productos);
			model.addAttribute("proveedores", proveedores);
			
			//modelos especificos para el index
			List<Cliente> clientes = this.serviceCliente.obtenerTodos();
			model.addAttribute("clientes", clientes);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
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
		try {
			Cliente cliente = new Cliente();
			cliente.setP_nombre(primerNombre);
			cliente.setS_nombre(segundoNombre);
			cliente.setP_apellido(primerApellido);
			cliente.setS_apellido(segundoApellido);
			cliente.setCorreo(correo);
			cliente.setDNI(dni);
			cliente.setDireccion(direccion);
			serviceCliente.crearCliente(cliente);
			
			Telefono telefonoCliente = new Telefono();
			telefonoCliente.setNumero(telefono);
			serviceTelefono.crear(telefonoCliente);
			
			//agregar telefono al proveedor
			int tmpClienteId = this.serviceCliente.buscarxNombre(cliente.getP_nombre());
			int tmpTelefonoId = this.serviceTelefono.buscarxNumero(telefonoCliente.getNumero());
			TelxCliente telxCliente = new TelxCliente(tmpTelefonoId, tmpClienteId);
			this.serviceTelxCliente.crear(telxCliente);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
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
		try {
			if(this.serviceCliente.exist(id)) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
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
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/";
	} 
	
	
	@PostMapping(value ="/proveedor/actualizarProveedor")
	public String actualizarProveedor(
                                @RequestParam(name = "id") int id,
                                @RequestParam(name = "nombre") String nombre,
								@RequestParam(name = "correo") String correo,
								@RequestParam(name = "direccion") String direccion,
								@RequestParam(name = "rtn") String rtn) {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
			}
		return "redirect:/";
	}
	
	//====================================================================
	//	Producto
	//====================================================================
	@PostMapping(value = "/producto/crearProducto")
	public String crearProducto(@RequestParam(name = "nombreProducto") String nombreProducto,
								@RequestParam(name = "fechaCaducidad") @DateTimeFormat(iso = ISO.DATE)  LocalDate fechaCaducidad,
								@RequestParam(name = "precio") float precio,
								@RequestParam(name = "unidadMedida") String unidadMedida,
								@RequestParam(name = "cantidadExistente") int cantidadExistente,
								@RequestParam(name = "codigoBarra") String codigoBarra,
								@RequestParam(name = "tipo") int tipo,
								@RequestParam(name = "seccion") int seccion,
								@RequestParam(name = "marca") int marca) {
		try {	
			Tipo_Producto tipo_producto = this.serviceTipo_Producto.buscar(tipo);
			Seccion_Producto seccion_producto = this.serviceSeccion_Producto.buscar(seccion);
			Marca marca_producto = this.serviceMarca.buscar(marca);
			
			Producto producto = new Producto();
			producto.setNombre_producto(nombreProducto);
			producto.setFecha_caducidad(fechaCaducidad);
			producto.setPrecio_venta(precio);
			producto.setMedida(unidadMedida);
			producto.setCantidad_disponible(cantidadExistente);
			producto.setCodigo_barra(codigoBarra);
			producto.setTipo_producto(tipo_producto);
			producto.setSeccion_producto(seccion_producto);
			producto.setMarca(marca_producto);
			serviceProducto.crear(producto);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/";
	}
	
	@GetMapping(value = "/producto/obtenerCombos")
	public String obtenerCombos() {
		return "modalCrearProducto";
	}
	
	@PostMapping(value = "producto/eliminarProducto")
	public String eliminarProducto(@RequestParam(name = "id") int id) {
		try {
			if(this.serviceProducto.exist(id)) {
				List<ProductosProveedores> productoProveedores = this.serviceProductosProveedores.obtenerTodosProductosProveedores();
				for (ProductosProveedores productoProveedor : productoProveedores) {
					if(productoProveedor.getId_Producto() == id) {
						this.serviceProductosProveedores.eliminar(productoProveedor);
					}
				}
				this.serviceProducto.eliminar(id);
				return "redirect:/";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/";
	}
	
	@PostMapping(value = "/producto/productoxProveedor")
	public String crearProductoxProveedor(@RequestParam(name = "idProducto") int id_Producto,
									@RequestParam(name = "idProveedor") int Id_proveedor,
									@RequestParam(name = "precioCompra") int precioCompra) {
		try {	
			Producto producto = this.serviceProducto.buscar(id_Producto);
			Proveedor proveedor = this.serviceProveedor.buscar(Id_proveedor);
			ProductosProveedores productosProveedores = new ProductosProveedores(id_Producto, Id_proveedor, precioCompra, producto, proveedor);
			this.serviceProductosProveedores.crearProductosProveedores(productosProveedores);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/";
	}
	
	@PostMapping(value ="/producto/actualizarProducto")
	public String actualizarProducto(@RequestParam(name = "id") int id,
									@RequestParam(name = "nombreProducto") String nombreProducto,
									@RequestParam(name = "precio") float precio,
									@RequestParam(name = "unidadMedida") String unidadMedida,
									@RequestParam(name = "cantidadExistente") int cantidadExistente,
									@RequestParam(name = "tipo") int tipo,
									@RequestParam(name = "seccion") int seccion,
									@RequestParam(name = "marca") int marca) {
		try {
			Producto producto = this.serviceProducto.buscar(id);
			if(this.serviceProducto.exist(id)) {
				if(!nombreProducto.equals("")) {
					producto.setNombre_producto(nombreProducto);
				}
				if(precio > 0) {
					producto.setPrecio_venta(precio);
				}
				if(!unidadMedida.equals("")) {
					producto.setMedida(unidadMedida);
				}
				if(cantidadExistente > 0) {
					producto.setCantidad_disponible(cantidadExistente);
				}
				if(tipo > 0) {
					Tipo_Producto tipo_producto = this.serviceTipo_Producto.buscar(tipo);
					producto.setTipo_producto(tipo_producto);
				}
				if(seccion > 0) {
					Seccion_Producto seccion_producto = this.serviceSeccion_Producto.buscar(seccion);
					producto.setSeccion_producto(seccion_producto);
				}
				if(marca > 0) {
					Marca marca_producto = this.serviceMarca.buscar(marca);
					producto.setMarca(marca_producto);
				}
				serviceProducto.crear(producto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/";
	}
	
	////////// tipo/ tipos de producto
	
	
	@PostMapping(value = "/tipo/crearTipo")
	public String crearTipo(@RequestParam(name = "nombre") String nombre) {
		try {
			Tipo_Producto tipoProducto = new Tipo_Producto();
			tipoProducto.setNombre_tipo_producto(nombre);
			serviceTipo_Producto.crear(tipoProducto);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/";
	}
	
	@PostMapping(value ="/tipo/actualizarTipo")
	public String actualizarTipo(@RequestParam(name = "id") int id,
                                @RequestParam(name = "nombre") String nombre) {
		try {
			if(this.serviceTipo_Producto.exist(id)) {
				Tipo_Producto tipo_producto = this.serviceTipo_Producto.buscar(id);
				if(!nombre.equals("")) {
					tipo_producto.setNombre_tipo_producto(nombre);
				}
			
			serviceTipo_Producto.crear(tipo_producto);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/";
	}
	
	//====================================================================
	//	Marca
	//====================================================================
	@PostMapping(value = "/marca/crearMarca")
	public String crearMarca(@RequestParam(name = "nombre") String nombre) {
		try {
			Marca marca= new Marca();
			marca.setNombre_marca(nombre);
			serviceMarca.crear(marca);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/";
	}
	
	@PostMapping(value ="/marca/actualizarMarca")
	public String actualizarMarca(@RequestParam(name = "id") int id,
                                @RequestParam(name = "nombre") String nombre) {
		try {
			if(this.serviceMarca.exist(id)) {
				Marca marca = this.serviceMarca.buscar(id);
				if(!nombre.equals("")) {
					marca.setNombre_marca(nombre);
				}
			serviceMarca.crear(marca);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:/";
	}
	
	//====================================================================
	//	Listados
	//====================================================================
	@RequestMapping(value ="proveedores/listaProveedores",method=RequestMethod.GET)
	public String listadoProveedores(Model model) {
		try {
			//Todos los modelos que ocuparan las paginas por defecto para popular la informaci??n
			List<Tipo_Producto> tiposDeProductos = this.serviceTipo_Producto.obtenerTodos();
			List<Seccion_Producto> seccionesDeProductos = this.serviceSeccion_Producto.obtenerTodos();
			List<Marca> marcasDeProductos = this.serviceMarca.obtenerTodos();
			List<Producto> productos = this.serviceProducto.obtenerTodos();
			List<Proveedor> proveedores = this.serviceProveedor.obtenerTodos();
			model.addAttribute("tiposDeProductos", tiposDeProductos);
			model.addAttribute("seccionesDeProductos", seccionesDeProductos);
			model.addAttribute("marcasDeProductos", marcasDeProductos);
			model.addAttribute("productos", productos);
			model.addAttribute("proveedores", proveedores);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "proveedores";
	}
	
	@RequestMapping(value ="/productos/listaProductos",method=RequestMethod.GET)
	public String listadoProductos(Model model) {
		try {
			List<Tipo_Producto> tiposDeProductos = this.serviceTipo_Producto.obtenerTodos();
			List<Seccion_Producto> seccionesDeProductos = this.serviceSeccion_Producto.obtenerTodos();
			List<Marca> marcasDeProductos = this.serviceMarca.obtenerTodos();
			List<Producto> productos = this.serviceProducto.obtenerTodos();
			List<Proveedor> proveedores = this.serviceProveedor.obtenerTodos();
			model.addAttribute("tiposDeProductos", tiposDeProductos);
			model.addAttribute("seccionesDeProductos", seccionesDeProductos);
			model.addAttribute("marcasDeProductos", marcasDeProductos);
			model.addAttribute("productos", productos);
			model.addAttribute("proveedores", proveedores);
		} catch (Exception e) {
			return "error";
		}
		return "productos";
	}
	
	@RequestMapping(value = "/clientes/listaClientes", method= RequestMethod.GET)
	public String listarClientes(Model model) {
		try {
			List<Tipo_Producto> tiposDeProductos = this.serviceTipo_Producto.obtenerTodos();
			List<Seccion_Producto> seccionesDeProductos = this.serviceSeccion_Producto.obtenerTodos();
			List<Marca> marcasDeProductos = this.serviceMarca.obtenerTodos();
			List<Producto> productos = this.serviceProducto.obtenerTodos();
			List<Proveedor> proveedores = this.serviceProveedor.obtenerTodos();
			model.addAttribute("tiposDeProductos", tiposDeProductos);
			model.addAttribute("seccionesDeProductos", seccionesDeProductos);
			model.addAttribute("marcasDeProductos", marcasDeProductos);
			model.addAttribute("productos", productos);
			model.addAttribute("proveedores", proveedores);
			List<Cliente> clientes = this.serviceCliente.obtenerTodos();
			model.addAttribute("clientes", clientes);
		} catch (Exception e) {
			return "error";
		}
		return "clientes";
	}

}
