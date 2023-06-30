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

    private boolean  isWinner;


    @OneToMany(mappedBy = "whitePlayer")
    private List<Game> whitePlayer;

    @OneToMany(mappedBy = "blackPlayer")
    private List<Game> blackPlayer;


}
