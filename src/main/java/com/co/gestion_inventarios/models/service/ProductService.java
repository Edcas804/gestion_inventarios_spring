package com.co.gestion_inventarios.models.service;

import com.co.gestion_inventarios.models.entity.Product;
import com.co.gestion_inventarios.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProduct {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product p) {
        return productRepository.save(p);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
