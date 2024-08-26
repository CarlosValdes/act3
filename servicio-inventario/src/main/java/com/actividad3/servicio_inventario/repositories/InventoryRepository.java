package com.actividad3.servicio_inventario.repositories;

import com.actividad3.servicio_inventario.model.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional <Inventory> findBySku(String sku);
}
