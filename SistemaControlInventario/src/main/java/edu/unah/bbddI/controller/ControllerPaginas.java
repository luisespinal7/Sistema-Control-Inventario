package edu.unah.bbddI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.bbddI.model.Marca;
import edu.unah.bbddI.model.Proveedor;
import edu.unah.bbddI.service.ServiceMarca;

@RestController
public class ControllerPaginas {

	@Autowired
	ServiceMarca serviceMarca;

	@GetMapping(value = "/marcas")
	public Marca crearMarca(@RequestParam(name = "id") int idMarca,
            					@RequestParam(name = "nombre") String nombre){
		Marca marca = new Marca(idMarca, nombre);
		this.serviceMarca.crear(marca);
		return this.serviceMarca.buscar(idMarca);
	}
	
	@RequestMapping(value = "/listar",method=RequestMethod.GET)
	public List<Marca> listarMarcas(){
		return this.serviceMarca.obtenerTodos();
		}
	

	
}
