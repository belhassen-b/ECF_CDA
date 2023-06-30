package com.example.ecf3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "result")
    private Game game;

    @ManyToOne
    private User winner;

    public void setResult(String result) {
        if (result.equals("white")) {
            this.winner = game.getWhitePlayer();
        } else if (result.equals("black")) {
            this.winner = game.getBlackPlayer();
        } else {
            this.winner = null;
        }
    }
}
