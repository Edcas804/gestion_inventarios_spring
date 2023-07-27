package com.co.gestion_inventarios.controllers;

import com.co.gestion_inventarios.models.entity.Product;
import com.co.gestion_inventarios.models.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public String index()
    {
        return "Product service is online";
    }
    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Integer id)
    {
        return service.findById(id);
    }

    @GetMapping("/")
    public List<Product> getAll(){
        return service.findAll();
    }

    @PostMapping
    public Product save(@RequestBody Product p)
    {
        return service.save(p);
    }
    @PutMapping("/{id}")
    public Product update(@RequestBody Product p, @PathVariable Integer id)
    {
        Product product = service.findById(id).get();
        product.setName(p.getName());
        product.setCategory(p.getCategory());
        product.setStock(p.getStock());
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
