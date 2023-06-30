package com.example.ecf3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User whitePlayer;

    @ManyToOne
    private User blackPlayer;

    private String dateTime;

    @ManyToOne
    private User winner;


    @OneToOne
    private Result result;

    @ManyToOne
    private Tournament tournament;


}
