package com.actividad3.servicio_inventario.services;

import com.actividad3.servicio_inventario.model.dtos.ProductRequest;
import com.actividad3.servicio_inventario.model.entities.Inventory;
import com.actividad3.servicio_inventario.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public Long isInStock(String sku) {

        var inventario=inventoryRepository.findBySku(sku);
        if (inventario.isPresent()) {
            return inventario.get().getQuantity();
        }
        return 0L;

    }

    public void addProduct(ProductRequest productRequest) {
        var product= Inventory.builder()
                .id(productRequest.getId())
                .quantity(productRequest.getQuantity())
                .sku(productRequest.getSku())
                .build();
        inventoryRepository.save(product);
    }


}
