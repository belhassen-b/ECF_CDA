package com.example.dto.utilisateur;


import lombok.Data;



@Data

public class ResponseUtilisateurDTO {
    private long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String avatar;

    private boolean isDriver;
    private boolean isAdmin;


}
