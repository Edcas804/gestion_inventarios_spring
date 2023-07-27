package com.co.gestion_inventarios.controllers;

import com.co.gestion_inventarios.models.entity.ResponseHandler;
import com.co.gestion_inventarios.models.entity.User;
import com.co.gestion_inventarios.models.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody User u)
    {
        User user = service.findByUsername(u.getUsername());
        if(user == null){
            return ResponseHandler.generateResponse("Datos incorrectos", HttpStatus.BAD_REQUEST, null);
        }
        if(!user.getPassword().equals(u.getPassword())){
            return ResponseHandler.generateResponse("Datos incorrectos", HttpStatus.BAD_REQUEST, null);
        }
        return ResponseHandler.generateResponse("Login exitoso", HttpStatus.OK, user);
    }
}
