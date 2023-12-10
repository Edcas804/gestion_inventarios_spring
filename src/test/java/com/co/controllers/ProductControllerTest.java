package com.co.controllers;

import com.co.gestion_inventarios.controllers.ProductController;
import com.co.gestion_inventarios.models.entity.Product;
import com.co.gestion_inventarios.models.entity.ResponseHandler;
import com.co.gestion_inventarios.models.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;
    @Mock
    ProductService productService;

    @Test
    public void sePuedeGuardar()
    {

        int id = 1;

        Product product = new Product();

        product.setCode(id);
        product.setName("Celular");
        product.setReference("Xiaomi");
        product.setCategory("Xkk2");
        product.setPrice("200");
        product.setStock(100);

        String message = "Creado";
        HttpStatus status = HttpStatus.OK;
        Object responseObject = productService.save(product);

        ResponseEntity<Object> responseEntity = ResponseHandler.generateResponse(message, status, responseObject);

        assertEquals(responseEntity.getStatusCode(), status);

        Map<String, Object> responseBody = (Map<String, Object>) responseEntity.getBody();

        assertEquals(responseBody.get("message"), message);
        assertEquals(responseBody.get("status"), status.value());
        assertEquals(responseBody.get("data"), responseObject);
    }


    @Test
    public void sePuedeBuscarPorId()
    {
        int id = 1;

        Product product = new Product();

        product.setCode(id);
        product.setName("Celular");
        product.setReference("Xiaomi");
        product.setCategory("Xkk2");
        product.setPrice("200");
        product.setStock(100);

        when(productService.findById(id)).thenReturn(Optional.of(product));

        Optional<Product> resProduct = productController.findById(id);

        assertNotNull(resProduct);
        assertTrue(resProduct.isPresent());
    }
}