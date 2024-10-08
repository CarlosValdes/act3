package com.actividad3.servicio_productos.controllers;

import org.springframework.web.bind.annotation.*;

import com.actividad3.servicio_productos.model.dtos.ProductRequest;
import com.actividad3.servicio_productos.services.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import com.actividad3.servicio_productos.model.dtos.ProductResponse;




@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest) {
        //TODO: process POST request
        this.productService.addProduct(productRequest);
      
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return this.productService.getAllProducts();
    }
    

}
