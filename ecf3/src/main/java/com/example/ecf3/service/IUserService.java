package com.example.ecf3.service;


import com.example.ecf3.entity.User;

import java.util.List;

public interface IUserService {
    User findByUsernameAndPassword(String username, String password);
    void save(User user);

    List<User>  findAll();

    User findById(Long id);

    boolean isAdmin();

    User findByUsername(String player1);
}
