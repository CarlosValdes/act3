package com.actividad3.servicio_productos.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actividad3.servicio_productos.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    
} 
