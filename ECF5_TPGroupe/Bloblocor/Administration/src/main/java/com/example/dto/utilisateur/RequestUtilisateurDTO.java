package com.example.dto.utilisateur;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestUtilisateurDTO {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String avatar;
    private boolean isDriver;
    private boolean isAdmin;



}
