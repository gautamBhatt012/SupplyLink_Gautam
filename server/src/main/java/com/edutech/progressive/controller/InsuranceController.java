package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Insurance;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8

import java.util.List;

public class InsuranceController {
    public ResponseEntity<List<Insurance>> getAllInsurances() {
        return null;
    }

    public ResponseEntity<Insurance> getInsuranceById(int insuranceId) {
        return null;
    }

    public ResponseEntity<Integer> createInsurance(Insurance insurance) {
        return null;
    }

    public ResponseEntity<Void> updateInsurance(int insuranceId, Insurance insurance) {
        return null;
    }

    public ResponseEntity<Void> deleteInsurance(int insuranceId) {
        return null;
    }
}
