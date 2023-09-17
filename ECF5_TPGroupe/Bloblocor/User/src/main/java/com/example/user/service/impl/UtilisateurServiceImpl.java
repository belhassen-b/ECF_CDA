package com.example.user.service.impl;

import com.example.user.dto.UtilisateurDTO;
import com.example.user.entity.Utilisateur;
import com.example.user.repository.UtilisateurRepository;
import com.example.user.service.UtilisateurService;
import com.example.user.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    @Autowired
    private Mapper mapper;

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public UtilisateurServiceImpl(UtilisateurRepository userRepository) {
        this.utilisateurRepository = userRepository;
    }


    @Override
    public Utilisateur createUser(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
        return utilisateur;
    }

    @Override
    public UtilisateurDTO getUserById(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        if (utilisateur.isPresent()) {
            UtilisateurDTO utisateurDTO = mapper.mapToDto(utilisateur.get());
            return utisateurDTO;
        }
        throw new RuntimeException("Not found");
    }

    @Override
    public List<UtilisateurDTO> getAllUsers() {
        List<Utilisateur> utilisateurs = (List<Utilisateur>) utilisateurRepository.findAll();
        List<UtilisateurDTO> utilisateurDTOS = utilisateurs.stream().map(user -> mapper.mapToDto(user)).toList();

        return utilisateurDTOS;
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        try {
            utilisateurRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Not found");
        }
    }


    @Override
    public UtilisateurDTO updateUserById(Long id, UtilisateurDTO utilisateurDTO) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);

        try {

            Utilisateur user = mapper.mapToEntity(utilisateurDTO);
            user.setId(id);
            utilisateurRepository.save(user);
            return utilisateurDTO;

        } catch (Exception e) {
            throw new RuntimeException("Not found");
        }
    }
}
