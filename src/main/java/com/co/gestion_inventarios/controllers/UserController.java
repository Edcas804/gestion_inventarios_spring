package com.co.gestion_inventarios.controllers;

import com.co.gestion_inventarios.models.entity.ResponseHandler;
import com.co.gestion_inventarios.models.entity.User;
import com.co.gestion_inventarios.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "https://dkotbo2u18ius.cloudfront.net")
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService service;
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Integer id)
    {
        return service.findById(id);
    }

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.generateResponse("Registros", HttpStatus.OK, service.findAll());
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody User p)
    {
        return ResponseHandler.generateResponse("Registro guardado", HttpStatus.OK, service.save(p));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody User u, @PathVariable Integer id)
    {
        User user = service.findById(id).get();
        user.setName(u.getName());
        user.setEmail(u.getEmail());
        user.setPassword(u.getPassword());
        user.setUsername(u.getUsername());
        user.setRole_id(u.getRole_id());
        user.setStatus(u.getStatus());

        return ResponseHandler.generateResponse("Actualizado", HttpStatus.OK, service.save(user));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
