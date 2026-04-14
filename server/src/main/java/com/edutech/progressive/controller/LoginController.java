package com.edutech.progressive.controller;

import com.edutech.progressive.dto.LoginRequest;
import com.edutech.progressive.entity.Supplier;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 7b8b6b15b44f8033d0cf04f837bd056175fab3f8

public class LoginController {
    public ResponseEntity<Supplier> registerUser(Supplier user) {
        return null;
    }

    public ResponseEntity loginUser(LoginRequest loginRequest) {
        return null;
    }
}
