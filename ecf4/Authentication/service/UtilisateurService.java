package com.example.authentication.service;

import com.example.authentication.entity.Utilisateur;
import com.example.authentication.repository.UtilisateurRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UtilisateurService  {

    private final UtilisateurRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(UtilisateurRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Utilisateur enregistrerUtilisateur(String username, String password) {
        Utilisateur user = new Utilisateur(username, password);
        return userRepository.save(user);
    }

    public Optional<Utilisateur> trouverParUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<Utilisateur> trouverParId(Long id) {
        return userRepository.findById(id);
    }
}
