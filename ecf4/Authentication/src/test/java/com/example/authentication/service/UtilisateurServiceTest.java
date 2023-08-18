package com.example.authentication.service;

import com.example.authentication.entity.Utilisateur;
import com.example.authentication.repository.UtilisateurRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UtilisateurServiceTest {

    @Mock
    private UtilisateurRepository userRepository;

    @InjectMocks
    private UtilisateurService utilisateurService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void shouldCreateUser() {
        //Arrange
        when(userRepository.save(any(Utilisateur.class))).thenReturn(new Utilisateur());

        //Act
        Utilisateur result = utilisateurService.enregistrerUtilisateur("username", "password");

        //Assert
        assertNotNull(result);

    }

    @Test
    void shouldFindUserByUsername() {
        //Arrange
        when(userRepository.findByUsername(any(String.class))).thenReturn(Optional.of(new Utilisateur()));

        //Act
        Optional<Utilisateur> result = utilisateurService.trouverParUsername("username");

        //Assert
        assertNotNull(result);
    }

    @Test
    void shouldFindUserById() {
        //Arrange
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(new Utilisateur()));

        //Act
        Optional<Utilisateur> result = utilisateurService.trouverParId(1L);

        //Assert
        assertNotNull(result);
    }

    @Test
    void shouldCheckIfUserExists() {
        //Arrange
        when(userRepository.existsById(any(Long.class))).thenReturn(true);

        //Act
        boolean result = utilisateurService.existById(1L);

        //Assert
        assertTrue(result);
    }
}