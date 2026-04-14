package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Shipment;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8

import java.util.List;

public class ShipmentController {

    public ResponseEntity<List<Shipment>> getAllShipments() {
        return null;
    }

    public ResponseEntity<Shipment> getShipmentById(int shipmentId) {
        return null;
    }

    public ResponseEntity<Integer> addShipment(Shipment shipment) {
        return null;
    }

    public ResponseEntity<Void> updateShipment(int shipmentId, Shipment shipment) {
        return null;
    }

    public ResponseEntity<Void> deleteShipment(int shipmentId) {
        return null;
    }
}
