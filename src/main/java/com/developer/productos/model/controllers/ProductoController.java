package com.developer.productos.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/producto")
public class ProductoController {
	
	private IProductoService productoService;

	@Autowired
	public ProductoController(IProductoService productoService) {
		this.productoService = productoService;
	}
	
	//Creamos una estructura de endpoint
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		return productoService.findById(id);
	}
	
	

}
