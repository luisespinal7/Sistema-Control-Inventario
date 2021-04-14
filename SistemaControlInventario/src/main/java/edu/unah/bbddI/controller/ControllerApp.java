package edu.unah.bbddI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.unah.bbddI.model.Marca;
import edu.unah.bbddI.model.Proveedor;
import edu.unah.bbddI.service.ServiceMarca;
import edu.unah.bbddI.service.ServiceProveedor;


@Controller
public class ControllerApp {
	
	@Autowired
	ServiceProveedor serviceProveedor;
	
	@GetMapping(value = {"/","/admin"})
	public String paginaPrincipal() {
		return "index";
	}
	
	@PostMapping(value ="/proveedor/crearProveedor")
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

}
