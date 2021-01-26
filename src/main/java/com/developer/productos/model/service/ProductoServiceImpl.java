package com.developer.productos.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developer.productos.model.entity.Producto;
import com.developer.productos.model.repository.ProductoRepository;

//Es componente, como un componente y lo podemos inyectar dependencias, en el controlador
//o en otros componentes
//Clase concreta que implemeta el IProductoService
@Service
public class ProductoServiceImpl implements IProductoService {

	private ProductoRepository productoRepo;

	@Autowired
	public ProductoServiceImpl(ProductoRepository productoRepo) {
		this.productoRepo = productoRepo;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoRepo.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		// orElse elemento que indica que si lo encuentra devuelv el dato si no null
		return productoRepo.findById(id).orElse(null);
	}

	

}
