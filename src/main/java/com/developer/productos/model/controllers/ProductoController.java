package com.developer.productos.model.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developer.productos.model.entity.Producto;
import com.developer.productos.model.service.IProductoService;

/**
 * 
 * Clase que representa el servicio web de cliente
 * 
 * @author Santiago Betancur
 * @email santiago-betancur@hotmail.com
 *
 */
// Este es con el fin de realizar conversión de todo poderlo devolver en json
// indicando que es controller

@RestController
//@RequestMapping("/api/producto")
public class ProductoController {
	
	//ribbon tiene algo llamado round robin, que ayuda a seleccionar el balanceo de carga
	// si son igual de buenas se van alternando
	//Primer metodo para manejar valores de .propertis
	@Autowired
	private Environment env;
	
	//Segundo metodo para manejar valores de .propertis
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductoService productoService;

	
	
	
	//Creamos una estructura de endpoint
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll().stream().map(producto -> {
			// comentado primer metodo te trer data de .propertis
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		// comentado primer metodo te trer data de .propertis
		//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		return productoService.findById(id);
	}
	
	

}
