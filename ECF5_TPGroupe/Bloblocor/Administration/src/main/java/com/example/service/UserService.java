package com.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.example.dto.utilisateur.RequestUtilisateurDTO;
import com.example.dto.utilisateur.ResponseUtilisateurDTO;
import com.example.utils.RestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.Collections;
import java.util.List;

public class UserService {

    private final RestClient _restClient;

    public UserService() {
        _restClient = new RestClient<ResponseUtilisateurDTO, RequestUtilisateurDTO>();
    }

    public ResponseUtilisateurDTO getById(int id)  {
        return (ResponseUtilisateurDTO) _restClient.get("/api/user/"+id, ResponseUtilisateurDTO.class);
    }

    public List<ResponseUtilisateurDTO> getAll()  {
        try {
            String jsonResponse = (String) _restClient.get("/api/user", String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonResponse, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    public ResponseUtilisateurDTO add(RequestUtilisateurDTO utilisateurDTO) {
        return (ResponseUtilisateurDTO) _restClient.post("/api/user", utilisateurDTO, ResponseUtilisateurDTO.class);
    }

    public String delete(Long id) {
        return (String) _restClient.delete("/api/user/"+id, String.class);
    }

    public ResponseUtilisateurDTO update(RequestUtilisateurDTO requestUtilisateurDTO) {
        return (ResponseUtilisateurDTO) _restClient.put("/api/user/"+requestUtilisateurDTO.getId(), requestUtilisateurDTO, ResponseUtilisateurDTO.class);
    }


}
