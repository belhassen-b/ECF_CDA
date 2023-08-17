package com.example.authentication.repository;

import com.example.authentication.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByUsername(String username);
}
