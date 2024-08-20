package com.actividad3.servicio_productos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.actividad3.servicio_productos.model.dtos.ProductRequest;
import com.actividad3.servicio_productos.model.dtos.ProductResponse;
import com.actividad3.servicio_productos.model.entities.Product;
import com.actividad3.servicio_productos.respositories.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j

public class ProductService {
    private final ProductRepository productRepository;
    public void addProduct(ProductRequest productRequest){
        var product= Product.builder()
        .sku(productRequest.getSku())
        .name(productRequest.getName())
        .description(productRequest.getDescription())
        .price(productRequest.getPrice())
                .image(productRequest.getImage())
        .build();
        productRepository.save(product);
        log.info("Product added: {}",product);
    }

    public List<ProductResponse> getAllProducts(){
        var products=productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
        .id(product.getId())
        .sku(product.getSku())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
                .image(product.getImage())
        .build();
    }
}
