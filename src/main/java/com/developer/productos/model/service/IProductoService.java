package com.developer.productos.model.service;

import java.util.List;

import com.developer.productos.model.entity.Producto;

//Para administrar los diferentes repository
public interface IProductoService  {

	
	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
}
