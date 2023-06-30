package com.example.ecf3.service.impl;


import com.example.ecf3.entity.User;
import com.example.ecf3.repository.IUserRepository;
import com.example.ecf3.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void save(User user) {
userRepository.save(user);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {

            return userRepository.findById(id).get();
    }

    @Override
    public boolean findIfUserExists(String username, String email) {
        return userRepository.existsByUsernameOrEmail(username, email);
    }
}
