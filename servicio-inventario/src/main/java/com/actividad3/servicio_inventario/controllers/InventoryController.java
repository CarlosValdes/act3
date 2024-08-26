package com.actividad3.servicio_inventario.controllers;

import com.actividad3.servicio_inventario.model.dtos.ProductRequest;
import com.actividad3.servicio_inventario.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public Long isInStock(@PathVariable String sku) {
        return inventoryService.isInStock(sku);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest) {
        //TODO: process POST request
        this.inventoryService.addProduct(productRequest);

    }
}
