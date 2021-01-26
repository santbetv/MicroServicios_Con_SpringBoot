package com.developer.productos.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.developer.productos.model.entity.Producto;


//Se llama tambien DAO
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	
	

}
