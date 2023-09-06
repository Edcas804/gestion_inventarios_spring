package com.co.gestion_inventarios.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name= "product")
public class Product {
    @Id
    @GeneratedValue
    private int code;
    private String name;
    private String reference;
    private int stock;
    private String category;

    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public Product() { }
    public Product(int code, String name, String reference, int stock, String category) {
        this.code = code;
        this.name = name;
        this.reference = reference;
        this.stock = stock;
        this.category = category;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", reference='" + reference + '\'' +
                ", stock=" + stock +
                ", category='" + category + '\'' +
                '}';
    }
}
