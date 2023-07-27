package com.co.gestion_inventarios.models.service;

import com.co.gestion_inventarios.models.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    public Optional<Product> findById(Integer id);
    public List<Product> findAll();
    public Product save(Product e);
    public void deleteById(Integer id);
}
