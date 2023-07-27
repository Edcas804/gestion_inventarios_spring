package com.co.gestion_inventarios.models.service;

import com.co.gestion_inventarios.models.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUser {
    public Optional<User> findById(Integer id);
    public List<User> findAll();
    public User save(User e);
    public void deleteById(Integer id);
    public User findByUsername(String username);
}
