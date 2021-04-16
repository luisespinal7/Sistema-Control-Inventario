package edu.unah.bbddI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.unah.bbddI.model.Proveedor;
import edu.unah.bbddI.model.Telefono;
import edu.unah.bbddI.model.TelxProveedor;
import edu.unah.bbddI.service.ServiceProveedor;
import edu.unah.bbddI.service.ServiceTelefono;
import edu.unah.bbddI.service.ServiceTelxProveedor;


@Controller
public class ControllerApp {
	
	@Autowired
	ServiceProveedor serviceProveedor;
	@Autowired
	ServiceTelefono serviceTelefono;
	@Autowired
	ServiceTelxProveedor serviceTelxProveedor;
	
	@GetMapping(value = {"/","/admin"})
	public String paginaPrincipal() {
		return "index";
	}
	
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

}
