package com.co.gestion_inventarios.controllers;

import com.co.gestion_inventarios.models.entity.Product;
import com.co.gestion_inventarios.models.entity.ResponseHandler;
import com.co.gestion_inventarios.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "https://dkotbo2u18ius.cloudfront.net")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Integer id)
    {
        return service.findById(id);
    }

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        return ResponseHandler.generateResponse("Registros", HttpStatus.OK, service.findAll());
    }
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Product p)
    {
        return ResponseHandler.generateResponse("Creado", HttpStatus.OK, service.save(p));
    }
    @PutMapping("/{id}")
    public Product update(@RequestBody Product p, @PathVariable Integer id)
    {
        Product product = service.findById(id).get();
        product.setName(p.getName());
        product.setCategory(p.getCategory());
        product.setStock(p.getStock());
        product.setReference(p.getReference());
        product.setStock(p.getStock());
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
