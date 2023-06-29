package com.example.ecf3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private boolean admin;


    @OneToMany(mappedBy = "player1")
    private List<Game> player1Games;

    @OneToMany(mappedBy = "player2")
    private List<Game> player2Games;


}
