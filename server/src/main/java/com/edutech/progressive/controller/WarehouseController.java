package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Warehouse;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD

import java.util.List;

=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8
public class WarehouseController {

    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return null;
    }

    public ResponseEntity<Warehouse> getWarehouseById(int warehouseId) {
        return null;
    }

    public ResponseEntity<Integer> addWarehouse(Warehouse warehouse) {
        return null;
    }

    public ResponseEntity<Void> updateWarehouse(int warehouseId, Warehouse warehouse) {
        return null;
    }

    public ResponseEntity<Void> deleteWarehouse(int warehouseId) {
        return null;
    }


    public ResponseEntity<List<Warehouse>> getWarehousesBySupplier(int supplierId) {
        return null;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8
